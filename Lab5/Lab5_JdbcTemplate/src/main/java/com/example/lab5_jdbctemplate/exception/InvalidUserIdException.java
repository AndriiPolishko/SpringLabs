package com.example.lab5_jdbctemplate.exception;

public class InvalidUserIdException extends Exception {
    public InvalidUserIdException(String message) {
        super(message);
    }
}
