package com.apietras.services.exceptions;



public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
