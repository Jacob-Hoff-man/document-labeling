package com.document.labeling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/courses/{courseId}/documents")
public class CourseDocumentController {

    @Autowired
    private CourseDocumentService courseDocumentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String postCourseDocument(
            @Valid @NotNull @RequestPart("file") final MultipartFile pdfFile,
            final @RequestPart("metadata") @Valid CourseDocumentPostRequest request) {
        System.out.println("@@ req" + request + " " + request.getName() + " " + request.getDescription());
        return courseDocumentService.parsePdfFile(pdfFile);
    }

}