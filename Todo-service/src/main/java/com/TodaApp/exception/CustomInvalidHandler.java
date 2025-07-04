package com.TodaApp.exception;

import com.TodaApp.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomInvalidHandler {

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidation(InvalidException ex){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        error.setCode(HttpStatus.UNAUTHORIZED.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

    }

}
