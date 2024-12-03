package com.document.labeling.dtos;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class CourseDocumentSentenceRecordListPostRequest {
    @NotEmpty
    private List<String[]> courseDocumentSentences;

    public CourseDocumentSentenceRecordListPostRequest() {
    }

    public CourseDocumentSentenceRecordListPostRequest(List<String[]> courseDocumentSentences) {
        this.courseDocumentSentences = courseDocumentSentences;
    }

    public List<String[]> getCourseDocumentSentences() {
        return courseDocumentSentences;
    }

    public void setCourseDocumentSentences(List<String[]> courseDocumentSentences) {
        this.courseDocumentSentences = courseDocumentSentences;
    }

    @Override
    public String toString() {
        return "CourseDocumentSentenceRecordListPostRequest [courseDocumentSentences=" + courseDocumentSentences + "]";
    }

}
