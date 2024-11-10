package com.document.labeling.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.labeling.daos.CoursePostRequest;
import com.document.labeling.exceptions.course.CourseNotFoundException;
import com.document.labeling.models.Course;
import com.document.labeling.repositories.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course postCourse(CoursePostRequest coursePostRequest) {
        Course course = new Course(
                ObjectId.get().toHexString(),
                coursePostRequest.getName(),
                coursePostRequest.getDescription());

        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new CourseNotFoundException("No course in the repository with id - " + id);
        }
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
