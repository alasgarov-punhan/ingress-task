package com.alasgarov.mscar.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException{
    private HttpStatus status;
    private int errorCode;
    private String message;

    public GeneralException(HttpStatus status, int errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
