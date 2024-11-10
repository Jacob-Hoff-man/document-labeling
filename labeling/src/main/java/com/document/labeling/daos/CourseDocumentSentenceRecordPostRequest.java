package com.document.labeling.daos;

import jakarta.validation.constraints.NotBlank;

public class CourseDocumentSentenceRecordPostRequest {
    @NotBlank(message = "courseId is required")
    private String courseId;
    @NotBlank(message = "courseId is required")
    private String documentId;
    private String[] words;
    private String[] labels;

    public CourseDocumentSentenceRecordPostRequest(String courseId, String documentId, String[] words,
            String[] labels) {
        this.courseId = courseId;
        this.documentId = documentId;
        this.words = words;
        this.labels = labels;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }
}
