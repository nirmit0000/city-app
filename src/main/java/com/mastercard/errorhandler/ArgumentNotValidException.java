package com.mastercard.errorhandler;

public class ArgumentNotValidException extends Exception {

    public ArgumentNotValidException() {
    }

    public ArgumentNotValidException(String message) {
        super(message);
    }

    public ArgumentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentNotValidException(Throwable cause) {
        super(cause);
    }
}
