package com.document.labeling.constants;

public class CourseDocumentSentenceRecordConstants {
    private CourseDocumentSentenceRecordConstants() {
    }

    public static String courseDocumentSentenceRecordNotFound(String courseId, String documentId, int sentenceId) {
        return String.format(
                "CourseDocumentSentenceRecord not found with course ID : %s, document ID : %s, sentence ID : %s",
                courseId, documentId, sentenceId);
    }
}
