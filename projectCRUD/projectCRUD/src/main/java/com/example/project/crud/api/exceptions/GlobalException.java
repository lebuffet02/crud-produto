package com.example.project.crud.api.exceptions;

import com.example.project.crud.api.exceptions.response.CustomErrorExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductErrorException.class)
    public ResponseEntity<CustomErrorExceptionResponse> customHandleNotFound(Exception e) {
        return new ResponseEntity<>(getCustomErrorExceptionResponse(e), HttpStatus.NOT_FOUND);
    }

    private CustomErrorExceptionResponse getCustomErrorExceptionResponse(Exception e) {
        CustomErrorExceptionResponse customErrorExceptionResponse = new CustomErrorExceptionResponse();
        customErrorExceptionResponse.setTimestamp(LocalDateTime.now());
        customErrorExceptionResponse.setError(e.getMessage());
        customErrorExceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return customErrorExceptionResponse;
    }
}
