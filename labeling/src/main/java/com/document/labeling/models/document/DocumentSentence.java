package com.document.labeling.models.document;

import java.util.Arrays;

public class DocumentSentence {
    private String[] words;
    private String[] labels;

    public DocumentSentence(String[] words, String[] labels) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        DocumentSentence other = (DocumentSentence) obj;
        if (!Arrays.equals(words, other.words))
            return false;
        if (!Arrays.equals(labels, other.labels))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DocumentSentence [words=" + Arrays.toString(words) + ", labels=" + Arrays.toString(labels) + "]";
    }

}
