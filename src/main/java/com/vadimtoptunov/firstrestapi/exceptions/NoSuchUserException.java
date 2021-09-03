package com.vadimtoptunov.firstrestapi.exceptions;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String message) {
        super(message);
    }
}
