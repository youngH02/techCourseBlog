package com.example._0907_pjt_blog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLosicException e){
        return new ResponseEntity(e.getExceptionCode(), HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
