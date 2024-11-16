package com.document.labeling.models.id;

public class CourseDocumentId {
    private String courseId;
    private String documentId;

    public CourseDocumentId(String courseId, String documentId) {
        this.courseId = courseId;
        this.documentId = documentId;
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
}
