package com.document.labeling.utils;

import com.document.labeling.daos.CoursePutRequest;
import com.document.labeling.models.Course;

public class CourseUtils {
    private CourseUtils() {
    }

    public static Course getUpdatedCourse(Course course, CoursePutRequest newCourse) {
        Course updatedCourse = course;
        if (newCourse.getName() != null)
            updatedCourse.setName(newCourse.getName());
        if (newCourse.getDescription() != null)
            updatedCourse.setDescription(newCourse.getDescription());
        if (updatedCourse.equals(course))
            return null;
        return updatedCourse;
    }
}
