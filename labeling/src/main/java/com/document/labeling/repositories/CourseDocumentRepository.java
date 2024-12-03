package com.document.labeling.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.document.labeling.models.id.CourseDocumentId;
import com.document.labeling.models.CourseDocument;

public interface CourseDocumentRepository extends MongoRepository<CourseDocument, CourseDocumentId> {
    @Query("{ '_id.courseId' : ?0 }")
    List<CourseDocument> findByCourseId(String courseId);
}
