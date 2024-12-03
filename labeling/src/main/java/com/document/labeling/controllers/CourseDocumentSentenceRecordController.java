package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.document.labeling.dtos.CourseDocumentSentenceRecordPutRequest;
import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.services.CourseDocumentSentenceRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses/{courseId}/documents/{documentId}/sentences")
public class CourseDocumentSentenceRecordController {

    @Autowired
    private CourseDocumentSentenceRecordService courseDocumentSentenceRecordService;

    @GetMapping("/{sentenceId}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDocumentSentenceRecord getCourseDocumentSentenceRecordById(
            @PathVariable String courseId,
            @PathVariable String documentId,
            @PathVariable int sentenceId) {
        return courseDocumentSentenceRecordService.getCourseDocumentSentenceRecordById(courseId, documentId,
                sentenceId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDocumentSentenceRecord> getCourseDocumentSentenceRecordList(
            @PathVariable String courseId,
            @PathVariable String documentId) {
        return courseDocumentSentenceRecordService.getAllCourseDocumentSentenceRecords(courseId, documentId);
    }

    @PutMapping("/{sentenceId}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDocumentSentenceRecord putCourseDocumentSentenceRecordById(
            @PathVariable String courseId,
            @PathVariable String documentId,
            @PathVariable int sentenceId,
            final @RequestBody @Valid CourseDocumentSentenceRecordPutRequest request) {
        return courseDocumentSentenceRecordService.putCourseDocumentSentenceRecordById(
                courseId,
                documentId,
                sentenceId,
                request);
    }

}
