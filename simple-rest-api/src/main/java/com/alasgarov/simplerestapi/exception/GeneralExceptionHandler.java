package com.alasgarov.simplerestapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

/*    @ExceptionHandler()
    public ResponseEntity<ApiErrorResponse> genericException(GeneralException e){
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        LocalDateTime.now(),
                        e.getStatus(),
                        e.getErrorCode(),
                        e.getMessage()), e.getStatus());
    }*/

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(LocalDateTime.now(), HttpStatus.NOT_ACCEPTABLE);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ErrorCode errorCode = new ErrorCode(
                    "code",
                    fieldName + " - " + errorMessage);
            errorResponse.getErrors().add(errorCode);
            errors.put(fieldName, errorMessage);
        });
        logger.info(String.format("Api validation error: %s", errors));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatusCode status,
//                                                                  WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        logger.info(String.format("Api validation error: %s",errors));
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(BindException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValid(BindException ex) {
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            FieldError fieldError = (FieldError) error;
//            String errorMessage = String.format("%s %s!", Objects.requireNonNull(fieldError).getField(), String.format("-%s", fieldError.getDefaultMessage()));
//            logger.error(errorMessage);
//        });
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("errorList");
//    }
}
