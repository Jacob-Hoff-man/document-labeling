package com.document.labeling.exceptions;

public class CourseDocumentNotFoundException extends RuntimeException {
    public CourseDocumentNotFoundException(String message) {
        super(message);
    }
}
