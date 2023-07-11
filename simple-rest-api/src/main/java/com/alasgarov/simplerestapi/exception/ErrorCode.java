package com.alasgarov.simplerestapi.exception;

import lombok.*;

@AllArgsConstructor
@Getter
public class ErrorCode {
    private String errorCode;
    private String message;
}
