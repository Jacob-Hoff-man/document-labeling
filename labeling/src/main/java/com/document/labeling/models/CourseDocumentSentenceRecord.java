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
}
