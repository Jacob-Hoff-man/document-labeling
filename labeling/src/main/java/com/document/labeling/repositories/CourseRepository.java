package com.document.labeling.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.document.labeling.models.Course;

/**
 * Repository used in storing course objects in database
 */
public interface CourseRepository extends MongoRepository<Course, String> {

}