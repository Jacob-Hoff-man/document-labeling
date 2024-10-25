package com.document.labeling.models.document;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CourseDocumentId other = (CourseDocumentId) obj;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        } else if (!courseId.equals(other.courseId))
            return false;
        if (documentId == null) {
            if (other.documentId != null)
                return false;
        } else if (!documentId.equals(other.documentId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CourseDocumentId [courseId=" + courseId + ", documentId=" + documentId + "]";
    }

}
