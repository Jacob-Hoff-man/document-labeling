package com.document.labeling.daos;

import jakarta.validation.constraints.NotEmpty;

public class CourseDocumentSentenceRecordPutRequest {
    @NotEmpty
    private String[] words;
    @NotEmpty
    private String[] labels;

    public CourseDocumentSentenceRecordPutRequest(@NotEmpty String[] words, @NotEmpty String[] labels) {
        this.words = words;
        this.labels = labels;
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
