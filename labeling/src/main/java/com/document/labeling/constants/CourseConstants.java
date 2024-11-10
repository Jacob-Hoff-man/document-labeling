package com.document.labeling.constants;

public class CourseConstants {
    private CourseConstants() {
    }

    public static String courseNotFound(String id) {
        return String.format("Course not found with id : %s", id);
    }

    public static String courseNotUpdated(String id) {
        return String.format("Course not updated, but was found with id : %s", id);
    }

}
