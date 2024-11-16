package com.document.labeling.utils;

import com.document.labeling.dtos.CoursePutRequest;
import com.document.labeling.models.Course;

public class CourseUtils {
    private CourseUtils() {
    }

    public static Course getUpdatedCourse(Course course, CoursePutRequest newCourse) {
        Course updatedCourse = new Course(course.getId(), course.getName(), course.getDescription());
        if (newCourse.getName() != null)
            updatedCourse.setName(newCourse.getName());
        if (newCourse.getDescription() != null)
            updatedCourse.setDescription(newCourse.getDescription());
        if (updatedCourse.equals(course))
            return null;
        return updatedCourse;
    }
}
