package com.document.labeling.models.id;


public class CourseDocumentSentenceRecordId {
    private String courseId;
    private String documentId;
    private int sentenceId;

    public CourseDocumentSentenceRecordId(String courseId, String documentId, int sentenceId) {
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

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

}
