package com.alasgarov.simplerestapi.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException{
    private HttpStatus status;
    private String errorCode;
    private String message;

    public GeneralException(HttpStatus status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
