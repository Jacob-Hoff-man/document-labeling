package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.document.labeling.services.CourseDocumentService;

import com.document.labeling.dtos.CourseDocumentPostRequest;
import com.document.labeling.dtos.CourseDocumentPostResponse;
import com.document.labeling.models.CourseDocument;

@RestController
@RequestMapping("/courses/{courseId}/documents")
public class CourseDocumentController {

    @Autowired
    private CourseDocumentService courseDocumentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseDocumentPostResponse postCourseDocument(
            @PathVariable String courseId,
            @Valid @NotNull @RequestPart("file") final MultipartFile pdfFile,
            final @RequestPart("metadata") @Valid CourseDocumentPostRequest request) {
        return courseDocumentService.postCourseDocumentAndCourseDocumentSentences(courseId, request, pdfFile);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDocument> getAllCourseDocuments(@PathVariable String courseId) {
        return courseDocumentService.getAllCourseDocuments(courseId);
    }

}
