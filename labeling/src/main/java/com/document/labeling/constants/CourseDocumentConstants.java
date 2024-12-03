package com.document.labeling.constants;

public class CourseDocumentConstants {
    private CourseDocumentConstants() {
    }

    public static String courseDocumentNotFound(String courseId, String documentId) {
        return String.format(
                "CourseDocument not found with course ID : %s, document ID : %s",
                courseId, documentId);
    }

    public static String courseDocumentFileNotAccepted() {
        return String.format("CourseDocument PDF file not accepted");
    }
}
