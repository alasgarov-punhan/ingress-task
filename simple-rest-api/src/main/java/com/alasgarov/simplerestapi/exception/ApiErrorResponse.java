package com.alasgarov.simplerestapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ApiErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;

    private List<ErrorCode> errors = new ArrayList<>();

    public ApiErrorResponse(LocalDateTime timestamp, HttpStatus status) {
        this.timestamp = timestamp;
        this.status = status;
    }
}
