package com.example.springpractice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppControllerAdvisor {
    private ResponseEntity<ErrorResponse> generateResponse(HttpStatus status, List<String> messages) {
        ErrorResponse res = new ErrorResponse(
                LocalDateTime.now(), status.value(),
                status.getReasonPhrase(), messages);

        return new ResponseEntity<>(res, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(
            MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream()
                .map(err -> String.format("%s - %s",
                        err.getField(), err.getDefaultMessage()))
                .toList();

        return generateResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleException() {
        return generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, new ArrayList<>());

    }



}
