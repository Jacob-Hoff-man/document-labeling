package com.document.labeling.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.document.labeling.models.document.DocumentSentenceRecord;
import com.document.labeling.models.document.DocumentSentenceRecordId;

/**
 * Repository used in storing document sentence record objects in database
 */
public interface CourseDocumentSentenceRecordRepository
                extends MongoRepository<DocumentSentenceRecord, DocumentSentenceRecordId> {

        @Query("{ 'id.courseId' : ?0, '_id.documentId' : ?1 }")
        List<DocumentSentenceRecord> findByCourseIdAndDocumentId(String courseId, String documentId);
}