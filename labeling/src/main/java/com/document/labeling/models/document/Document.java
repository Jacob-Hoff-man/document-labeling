package com.document.labeling.models.document;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class Document {
    @Id
    private CourseDocumentId id;
    private Map<String, DocumentSentence> documentSentences;

    public Document(CourseDocumentId id, Map<String, DocumentSentence> documentSentences) {
        this.id = id;
        this.documentSentences = documentSentences;
    }

    public CourseDocumentId getId() {
        return id;
    }

    public void setId(CourseDocumentId id) {
        this.id = id;
    }

    public Map<String, DocumentSentence> getDocumentSentences() {
        return documentSentences;
    }

    public void setDocumentSentences(Map<String, DocumentSentence> documentSentences) {
        this.documentSentences = documentSentences;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((documentSentences == null) ? 0 : documentSentences.hashCode());
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
        Document other = (Document) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (documentSentences == null) {
            if (other.documentSentences != null)
                return false;
        } else if (!documentSentences.equals(other.documentSentences))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Document [id=" + id + ", documentSentences=" + documentSentences + "]";
    }

}
