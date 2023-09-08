package com.example._0907_pjt_blog.exception;

import lombok.Getter;

public class BusinessLosicException extends RuntimeException{
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLosicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;

    }
}
