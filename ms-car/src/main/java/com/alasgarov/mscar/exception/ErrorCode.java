package com.alasgarov.mscar.exception;

public enum ErrorCode {
    DUPLICATE_OWNER(1, "This owner already exists"),
    CAR_NOT_FOUND(2, "Car could not find by id"),
    OWNER_NOT_FOUND(3, "Owner could not find by id"),
    DRIVER_NOT_FOUND(4, "Driver could not find by id");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}