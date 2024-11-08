package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.document.labeling.models.Course;
import com.document.labeling.models.request.CoursePostRequest;
import com.document.labeling.services.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course postCourse(final @RequestBody CoursePostRequest course) {
        return courseService.postCourse(course);
    }

    @DeleteMapping("/courses")
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}
