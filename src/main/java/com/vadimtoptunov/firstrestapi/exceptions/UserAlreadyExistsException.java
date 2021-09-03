package com.vadimtoptunov.firstrestapi.exceptions;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
