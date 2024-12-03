package com.document.labeling.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.document.labeling.models.id.CourseDocumentSentenceRecordId;

@Document(collection = "course_document_sentences")
public class CourseDocumentSentenceRecord extends Base {
    @Id
    CourseDocumentSentenceRecordId id;
    private String[] words;
    private String[] labels;

    public CourseDocumentSentenceRecord(CourseDocumentSentenceRecordId id, String[] words, String[] labels) {
        this.id = id;
        this.words = words;
        this.labels = labels;
    }

    public CourseDocumentSentenceRecordId getId() {
        return id;
    }

    public void setId(CourseDocumentSentenceRecordId id) {
        this.id = id;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (!Arrays.equals(words, other.words))
            return false;
        if (!Arrays.equals(labels, other.labels))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CourseDocumentSentenceRecord [id=" + id + ", words=" + Arrays.toString(words) + ", labels="
                + Arrays.toString(labels) + "]";
    }

}
