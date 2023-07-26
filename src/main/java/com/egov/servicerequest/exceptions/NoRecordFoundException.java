package com.egov.servicerequest.exceptions;

public class NoRecordFoundException extends  RuntimeException{

    public NoRecordFoundException(String message) {
        super(message);
    }

    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
