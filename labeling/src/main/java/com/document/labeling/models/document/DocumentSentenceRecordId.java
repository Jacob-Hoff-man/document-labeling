package com.document.labeling.models.document;

public class DocumentSentenceRecordId {
    private String courseId;
    private String documentId;
    private String sentenceId;

    public DocumentSentenceRecordId(String courseId, String documentId, String sentenceId) {
        this.courseId = courseId;
        this.documentId = documentId;
        this.sentenceId = sentenceId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getSentenceId() {
        return sentenceId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setSentenceId(String sentenceId) {
        this.sentenceId = sentenceId;
    }

    @Override
    public String toString() {
        return "DocumentId [courseId=" + courseId + ", documentId=" + documentId + ", sentenceId=" + sentenceId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
        result = prime * result + ((sentenceId == null) ? 0 : sentenceId.hashCode());
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
        DocumentSentenceRecordId other = (DocumentSentenceRecordId) obj;
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
        if (sentenceId == null) {
            if (other.sentenceId != null)
                return false;
        } else if (!sentenceId.equals(other.sentenceId))
            return false;
        return true;
    }
}
