package com.document.labeling.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.labeling.constants.CourseConstants;
import com.document.labeling.daos.CoursePostRequest;
import com.document.labeling.daos.CoursePutRequest;
import com.document.labeling.exceptions.course.CourseNotFoundException;
import com.document.labeling.exceptions.course.CourseNotUpdatedException;
import com.document.labeling.models.Course;
import com.document.labeling.repositories.CourseRepository;
import com.document.labeling.utils.CourseUtils;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course postCourse(CoursePostRequest coursePostRequest) {
        Course course = new Course(
                ObjectId.get().toHexString(),
                coursePostRequest.getName(),
                coursePostRequest.getDescription());

        return courseRepository.insert(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new CourseNotFoundException(CourseConstants.courseNotFound(id));
        }
    }

    public Course putCourseById(String id, CoursePutRequest coursePutRequest)
            throws CourseNotFoundException, CourseNotUpdatedException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course updatedCourse = CourseUtils.getUpdatedCourse(course.get(), coursePutRequest);
            if (updatedCourse == null)
                throw new CourseNotUpdatedException(CourseConstants.courseNotUpdated(id));
            return courseRepository.save(updatedCourse);
        } else {
            throw new CourseNotFoundException(CourseConstants.courseNotFound(id));
        }
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

    public void deleteCourseById(String id) throws CourseNotFoundException {
        if (courseRepository.existsById(id))
            courseRepository.deleteById(id);
        else
            throw new CourseNotFoundException(CourseConstants.courseNotFound(id));
    }
}
