package com.adtec.crowd.exception;

public class LoginFailedException extends  RuntimeException{

    private static final long serialVersionUID = -6812958233638040321L;

    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

}
