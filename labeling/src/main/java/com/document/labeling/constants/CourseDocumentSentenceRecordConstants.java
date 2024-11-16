package com.document.labeling.constants;

public class CourseDocumentSentenceRecordConstants {
    private CourseDocumentSentenceRecordConstants() {
    }

    public static String courseDocumentSentenceRecordNotFound(String courseId, String documentId, int sentenceId) {
        return String.format(
                "CourseDocumentSentenceRecord not found with course ID : %s, document ID : %s, sentence ID : %s",
                courseId, documentId, sentenceId);
    }

    public static String courseDocumentSentenceRecordNotUpdated(String courseId, String documentId, int sentenceId) {
        return String.format(
                "CourseDocumentSentenceRecord not updated, but was found with course ID : %s, document ID: %s, sentence ID : %s",
                courseId, documentId, sentenceId);
    }

    public static String courseDocumentSentenceRecordWordsAndLabelsLengthNotEqual(String courseId, String documentId,
            int sentenceId) {
        return String.format(
                "CourseDocumentSentenceRecord with course ID : %s, document ID: %s, sentence ID : %s does not have matching length for words and labels property",
                courseId, documentId, sentenceId);
    }
}
