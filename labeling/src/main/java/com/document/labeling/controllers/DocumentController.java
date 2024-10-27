package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.document.labeling.models.document.Document;
import com.document.labeling.models.document.DocumentSentenceRecord;
import com.document.labeling.services.DocumentService;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents/{documentId}")
    public List<DocumentSentenceRecord> getDocumentById(@PathVariable String documentId) {
        return documentService.getDocument(documentId);
    }

    @PostMapping("/documents")
    public Document postDocument(final @RequestBody Document document) {
        return documentService.postDocument(document);
    }
}

