package com.document.labeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.document.labeling.daos.CourseDocumentSentenceRecordListPostRequest;
import com.document.labeling.models.CourseDocumentSentenceRecord;
import com.document.labeling.services.CourseDocumentSentenceRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses/{courseId}/documents")
public class CourseDocumentSentenceRecordController {

    @Autowired
    private CourseDocumentSentenceRecordService courseDocumentSentenceRecordService;

    // TODO: replace this with a POST CourseDocument endpoint, and internally use
    // service fcn
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDocumentSentenceRecord> postCourseDocumentSentenceRecordList(
            @PathVariable String courseId,
            @PathVariable String id,
            final @RequestBody @Valid CourseDocumentSentenceRecordListPostRequest request) {
        System.out.println("@@post cdsrl " + courseId + " " + id + " " + request.toString());
        return courseDocumentSentenceRecordService.postCourseDocumentSentenceRecordList(courseId, id, request);
    }

}
