package com.document.labeling.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.document.labeling.models.id.CourseDocumentSentenceRecordId;

@Document(collection = "course_document_sentences")
public class CourseDocumentSentenceRecord extends Base {
    @Id
    CourseDocumentSentenceRecordId documentSentenceRecordId;
    private String[] words;
    private String[] labels;

    public CourseDocumentSentenceRecord(CourseDocumentSentenceRecordId documentSentenceRecordId, String[] words,
            String[] labels) {
        super();
        this.documentSentenceRecordId = documentSentenceRecordId;
        this.words = words;
        this.labels = labels;
    }

    public CourseDocumentSentenceRecordId getDocumentSentenceRecordId() {
        return documentSentenceRecordId;
    }

    public void setDocumentSentenceRecordId(CourseDocumentSentenceRecordId documentSentenceRecordId) {
        this.documentSentenceRecordId = documentSentenceRecordId;
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

    @Override
    public String toString() {
        return "CourseDocumentSentenceRecord [documentSentenceRecordId=" + documentSentenceRecordId + ", words="
                + Arrays.toString(words) + ", labels=" + Arrays.toString(labels) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((documentSentenceRecordId == null) ? 0 : documentSentenceRecordId.hashCode());
        result = prime * result + Arrays.hashCode(words);
        result = prime * result + Arrays.hashCode(labels);
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
        CourseDocumentSentenceRecord other = (CourseDocumentSentenceRecord) obj;
        if (documentSentenceRecordId == null) {
            if (other.documentSentenceRecordId != null)
                return false;
        } else if (!documentSentenceRecordId.equals(other.documentSentenceRecordId))
            return false;
        if (!Arrays.equals(words, other.words))
            return false;
        if (!Arrays.equals(labels, other.labels))
            return false;
        return true;
    }
}
