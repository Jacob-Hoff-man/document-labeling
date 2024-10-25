package com.document.labeling.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.labeling.models.document.Document;
import com.document.labeling.models.document.DocumentSentence;
import com.document.labeling.models.document.DocumentSentenceRecord;
import com.document.labeling.models.document.DocumentSentenceRecordId;
import com.document.labeling.repositories.DocumentSentenceRecordRepository;

@Service
public class DocumentService {
    @Autowired
    private DocumentSentenceRecordRepository documentSentenceRecordRepository;

    public Document postDocument(Document document) {
        for (Map.Entry<String, DocumentSentence> ds : document.getDocumentSentences().entrySet()) {
            String sentenceId = ds.getKey();
            DocumentSentenceRecordId recordId = new DocumentSentenceRecordId(document.getId().getCourseId(),
                    document.getId().getDocumentId(), sentenceId);
            DocumentSentence value = ds.getValue();
            DocumentSentenceRecord dsr = new DocumentSentenceRecord(
                    recordId,
                    value.getWords(),
                    value.getLabels());
            documentSentenceRecordRepository.save(dsr);
        }
        return document;
    }

    public List<DocumentSentenceRecord> getDocument(String documentId) {
        return documentSentenceRecordRepository.findByDocumentId(documentId);
    }
}
