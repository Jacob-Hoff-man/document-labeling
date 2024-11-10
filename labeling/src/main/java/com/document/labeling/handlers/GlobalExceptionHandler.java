package com.document.labeling.handlers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.document.labeling.exceptions.course.CourseAlreadyExistsException;
import com.document.labeling.exceptions.course.CourseNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Global validation exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDetail handleValidationExceptions(MethodArgumentNotValidException exception,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ErrorDetail(new Date(), errors.toString(), request.getDescription(false));
    }

    // Global request body required exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorDetail handleCourseInvalidException(HttpMessageNotReadableException exception, WebRequest request) {
        return new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
    }

    // Course exceptions
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CourseNotFoundException.class)
    public ErrorDetail handleCourseNotFoundException(CourseNotFoundException exception, WebRequest request) {
        return new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(CourseAlreadyExistsException.class)
    public ErrorDetail handleCourseAlreadyExistsException(CourseAlreadyExistsException exception, WebRequest request) {
        return new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
    }

    // Catch unexpected exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDetail handleException(Exception exception, WebRequest request) {
        return new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
    }
}
