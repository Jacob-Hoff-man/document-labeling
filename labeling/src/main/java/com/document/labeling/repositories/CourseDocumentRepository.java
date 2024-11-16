package com.document.labeling.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.document.labeling.models.id.CourseDocumentId;
import com.document.labeling.models.CourseDocument;

public interface CourseDocumentRepository extends MongoRepository<CourseDocument, CourseDocumentId> {

}
