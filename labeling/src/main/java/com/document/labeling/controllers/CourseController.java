package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.document.labeling.daos.CoursePostRequest;
import com.document.labeling.models.Course;
import com.document.labeling.services.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public Course postCourse(final @RequestBody @Valid CoursePostRequest course) {
        return courseService.postCourse(course);
    }

    @DeleteMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}
