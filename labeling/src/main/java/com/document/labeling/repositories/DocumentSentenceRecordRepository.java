package com.document.labeling.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.document.labeling.models.document.DocumentSentenceRecord;
import com.document.labeling.models.document.DocumentSentenceRecordId;

/**
 * Repository used in storing document sentence record objects in database
 */
public interface DocumentSentenceRecordRepository
                extends MongoRepository<DocumentSentenceRecord, DocumentSentenceRecordId> {

        @Query("{ '_id.documentId' : ?0 }")
        List<DocumentSentenceRecord> findByDocumentId(String documentId);
}