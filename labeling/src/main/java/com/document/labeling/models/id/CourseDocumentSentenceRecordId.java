package com.document.labeling.models.id;

public class CourseDocumentSentenceRecordId {
    private String courseId;
    private String documentId;
    private String sentenceId;

    public CourseDocumentSentenceRecordId(String courseId, String documentId, String sentenceId) {
        this.courseId = courseId;
        this.documentId = documentId;
        this.sentenceId = sentenceId;
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

    public String getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(String sentenceId) {
        this.sentenceId = sentenceId;
    }
}
