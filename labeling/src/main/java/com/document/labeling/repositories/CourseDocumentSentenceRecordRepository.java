package com.document.labeling.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.models.id.CourseDocumentSentenceRecordId;

/**
 * Repository used in storing document sentence record objects in database
 */
public interface CourseDocumentSentenceRecordRepository
                extends MongoRepository<CourseDocumentSentenceRecord, CourseDocumentSentenceRecordId> {

        @Query("{ '_id.courseId' : ?0, '_id.documentId' : ?1 }")
        List<CourseDocumentSentenceRecord> findByCourseIdAndDocumentId(String courseId, String documentId);
}