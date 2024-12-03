package com.document.labeling.dtos;

import java.util.List;

import com.document.labeling.models.CourseDocument;
import com.document.labeling.models.CourseDocumentSentenceRecord;

public class CourseDocumentPostResponse {
    private CourseDocument courseDocument;
    private List<CourseDocumentSentenceRecord> courseDocumentSentenceRecords;

    public CourseDocumentPostResponse(CourseDocument courseDocument,
            List<CourseDocumentSentenceRecord> courseDocumentSentenceRecords) {
        this.courseDocument = courseDocument;
        this.courseDocumentSentenceRecords = courseDocumentSentenceRecords;
    }

    public CourseDocument getCourseDocument() {
        return courseDocument;
    }

    public void setCourseDocument(CourseDocument courseDocument) {
        this.courseDocument = courseDocument;
    }

    public List<CourseDocumentSentenceRecord> getCourseDocumentSentenceRecords() {
        return courseDocumentSentenceRecords;
    }

    public void setCourseDocumentSentenceRecords(List<CourseDocumentSentenceRecord> courseDocumentSentenceRecords) {
        this.courseDocumentSentenceRecords = courseDocumentSentenceRecords;
    }
}
