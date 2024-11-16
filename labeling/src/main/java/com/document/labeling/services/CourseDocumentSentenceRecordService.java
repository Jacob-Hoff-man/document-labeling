package com.document.labeling.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.labeling.constants.CourseDocumentSentenceRecordConstants;
import com.document.labeling.constants.LabelConstants;
import com.document.labeling.daos.CourseDocumentSentenceRecordListPostRequest;
import com.document.labeling.daos.CourseDocumentSentenceRecordPutRequest;
import com.document.labeling.exceptions.CourseDocumentSentenceRecordNotFoundException;
import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.models.id.CourseDocumentSentenceRecordId;
import com.document.labeling.repositories.CourseDocumentSentenceRecordRepository;

@Service
public class CourseDocumentSentenceRecordService {
    @Autowired
    private CourseDocumentSentenceRecordRepository courseDocumentSentenceRecordRepository;
    @Autowired
    private CourseService courseService;

    public List<CourseDocumentSentenceRecord> getAllCourseDocumentSentenceRecords(String courseId, String documentId) {
        return courseDocumentSentenceRecordRepository.findByCourseIdAndDocumentId(courseId, documentId);
    }

    public CourseDocumentSentenceRecord putCourseDocumentSentenceRecordById(
            String courseId,
            String documentId,
            int sentenceId,
            CourseDocumentSentenceRecordPutRequest request) {
        CourseDocumentSentenceRecordId id = new CourseDocumentSentenceRecordId(courseId, documentId, sentenceId);
        Optional<CourseDocumentSentenceRecord> cdsr = courseDocumentSentenceRecordRepository.findById(id);
        if (cdsr.isPresent()) {
            // TODO: update to have validations on words and labels length
            // for now, only update labels and not words
            CourseDocumentSentenceRecord updatedCdsr = cdsr.get();
            updatedCdsr.setLabels(request.getLabels());
            return courseDocumentSentenceRecordRepository.save(updatedCdsr);

        } else {
            throw new CourseDocumentSentenceRecordNotFoundException(CourseDocumentSentenceRecordConstants
                    .courseDocumentSentenceRecordNotFound(courseId, documentId, sentenceId));
        }
    }

    public List<CourseDocumentSentenceRecord> postCourseDocumentSentenceRecordList(
            String courseId,
            String documentId,
            CourseDocumentSentenceRecordListPostRequest request) {
        // Throws CourseNotFound exception if dne
        courseService.getCourseById(courseId);
        // TODO: add CourseDocument findById validation

        List<CourseDocumentSentenceRecord> records = new ArrayList<>();
        int index = 0;
        for (String[] sentence : request.getCourseDocumentSentences()) {
            CourseDocumentSentenceRecordId id = new CourseDocumentSentenceRecordId(
                    courseId,
                    documentId,
                    index++);
            String[] labels = new String[sentence.length];
            Arrays.fill(labels, LabelConstants.OUTSIDE);
            CourseDocumentSentenceRecord cdsr = new CourseDocumentSentenceRecord(id, sentence, labels);
            records.add(courseDocumentSentenceRecordRepository.insert(cdsr));
        }
        return records;
    }
}