package com.emedlogix.exception;

public class EmedlogixServiceException extends RuntimeException{
    public EmedlogixServiceException(String message) {
        super(message);
    }

    public EmedlogixServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
