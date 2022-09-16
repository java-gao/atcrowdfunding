package com.adtec.crowd.exception;

public class AccessForbiddenException extends RuntimeException{

    private static final long serialVersionUID = 8092090499165936309L;

    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

}
