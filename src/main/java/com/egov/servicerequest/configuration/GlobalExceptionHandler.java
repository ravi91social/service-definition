package com.egov.servicerequest.configuration;

import com.egov.servicerequest.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Error> generateException(ResponseStatusException responseStatusException) {
        Error error = new Error();
        error.setCode(String.valueOf(responseStatusException.getStatus().value()));
        error.setMessage(responseStatusException.getReason());
        error.setDescription(responseStatusException.getCause().getMessage());
        return new ResponseEntity<Error>(error, responseStatusException.getStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> generateException(NotFoundException notFoundException) {
        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setMessage("the requested resource does not exist");
        error.setDescription(notFoundException.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Error> generateException(IOException ioException) {
        Error error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        error.setMessage("io exception occured");
        error.setDescription(ioException.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> generateException(Exception exception) {
        Error error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        error.setMessage("A generic error occurred on the server");
        error.setDescription(exception.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
