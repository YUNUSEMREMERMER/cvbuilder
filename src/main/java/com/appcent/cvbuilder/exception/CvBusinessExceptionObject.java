package com.appcent.cvbuilder.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CvBusinessExceptionObject {
    private String errorCode;
    private Object errorMessage;
    private HttpStatus httpStatus;

    public CvBusinessExceptionObject() {
    }

    public CvBusinessExceptionObject(final String errCode, final Object errorMessage, final HttpStatus httpStatus) {
        this.errorCode = errCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}
