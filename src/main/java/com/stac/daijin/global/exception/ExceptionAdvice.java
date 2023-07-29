package com.stac.daijin.global.exception;

import com.stac.daijin.global.exception.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> businessException(BusinessException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ExceptionResponse(e.getMessage()));
    }

}
