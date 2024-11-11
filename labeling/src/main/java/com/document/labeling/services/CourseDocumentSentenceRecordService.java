package com.document.labeling.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.labeling.constants.LabelConstants;
import com.document.labeling.daos.CourseDocumentSentenceRecordListPostRequest;
import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.models.id.CourseDocumentSentenceRecordId;
import com.document.labeling.repositories.CourseDocumentSentenceRecordRepository;

@Service
public class CourseDocumentSentenceRecordService {
    @Autowired
    private CourseDocumentSentenceRecordRepository courseDocumentSentenceRecordRepository;
    @Autowired
    private CourseService courseService;

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