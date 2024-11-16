package com.document.labeling.daos;

public class CourseDocumentSentenceRecordPutRequest {
    private String[] words;
    private String[] labels;

    public CourseDocumentSentenceRecordPutRequest(String[] words, String[] labels) {
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
