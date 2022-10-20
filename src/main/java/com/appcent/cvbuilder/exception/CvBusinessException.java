package com.appcent.cvbuilder.exception;


import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CvBusinessException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;
    
    public CvBusinessException(){}

    public CvBusinessException(final String errorCode, final String errorMessage, final HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

}