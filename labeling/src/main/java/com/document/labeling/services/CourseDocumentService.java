package com.document.labeling.services;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.document.labeling.constants.CourseDocumentConstants;
import com.document.labeling.dtos.CourseDocumentPostRequest;
import com.document.labeling.dtos.CourseDocumentPostResponse;
import com.document.labeling.dtos.CourseDocumentSentenceRecordListPostRequest;
import com.document.labeling.exceptions.CourseDocumentFileNotAcceptedException;
import com.document.labeling.exceptions.CourseDocumentNotFoundException;
import com.document.labeling.models.CourseDocument;
import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.models.id.CourseDocumentId;
import com.document.labeling.pipelines.CourseDocumentPipeline;
import com.document.labeling.repositories.CourseDocumentRepository;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@Service
public class CourseDocumentService {
    @Autowired
    private CourseDocumentRepository courseDocumentRepository;
    @Autowired
    private CourseDocumentSentenceRecordService courseDocumentSentenceRecordService;

    public String getCourseDocumentStringFromPdfFile(final MultipartFile file) {
        try {
            final PDDocument document = Loader.loadPDF(file.getBytes());
            final PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            throw new CourseDocumentFileNotAcceptedException(CourseDocumentConstants.courseDocumentFileNotAccepted());
        }
    }

    public List<String[]> getCourseDocumentSentencesfromCourseDocumentString(String courseDocumentString) {
        StanfordCoreNLP pipeline = CourseDocumentPipeline.getPipeline();
        CoreDocument cd = new CoreDocument(courseDocumentString);
        pipeline.annotate(cd);
        List<String[]> sentences = new ArrayList<>();
        for (CoreSentence cs : cd.sentences()) {
            List<String> tokensStringList = cs.tokensAsStrings();
            String[] sentence = tokensStringList.toArray(new String[tokensStringList.size()]);
            sentences.add(sentence);
        }
        return sentences;

    }

    public CourseDocument postCourseDocument(String courseId, CourseDocumentPostRequest request) {
        CourseDocumentId id = new CourseDocumentId(
                courseId,
                ObjectId.get().toHexString());
        CourseDocument courseDocument = new CourseDocument(
                id,
                request.getName(),
                request.getDescription());

        return courseDocumentRepository.insert(courseDocument);
    }

    public CourseDocumentPostResponse postCourseDocumentAndCourseDocumentSentences(String courseId,
            CourseDocumentPostRequest request, final MultipartFile file) {
        // verify file is parsable before creating db records
        String courseDocumentString = this.getCourseDocumentStringFromPdfFile(file);
        // create CourseDocument record and get id
        CourseDocument courseDocument = this.postCourseDocument(courseId, request);
        // get course document sentences
        List<String[]> courseDocumentSentences = this
                .getCourseDocumentSentencesfromCourseDocumentString(courseDocumentString);
        // create CourseDocumentSentenceRecords
        List<CourseDocumentSentenceRecord> courseDocumentSentenceRecords = this.courseDocumentSentenceRecordService
                .postCourseDocumentSentenceRecordList(
                        courseId, courseDocument.getId().getDocumentId(),
                        new CourseDocumentSentenceRecordListPostRequest(courseDocumentSentences));
        // build response
        return new CourseDocumentPostResponse(courseDocument,
                courseDocumentSentenceRecords);
    }

    public List<CourseDocument> getAllCourseDocuments(String courseId) {
        return courseDocumentRepository.findByCourseId(courseId);
    }

    public CourseDocument getCourseDocumentById(String courseId, String documentId) {
        Optional<CourseDocument> cd = courseDocumentRepository
                .findById(new CourseDocumentId(courseId, documentId));
        if (cd.isPresent()) {
            return cd.get();
        } else {
            throw new CourseDocumentNotFoundException(CourseDocumentConstants
                    .courseDocumentNotFound(courseId, documentId));
        }
    }
}
