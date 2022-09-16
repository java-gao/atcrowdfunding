package com.adtec.crowd.exception;

public class LoginAcctExistException extends RuntimeException{
    public LoginAcctExistException() {
    }

    public LoginAcctExistException(String message) {
        super(message);
    }

    public LoginAcctExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctExistException(Throwable cause) {
        super(cause);
    }
}
