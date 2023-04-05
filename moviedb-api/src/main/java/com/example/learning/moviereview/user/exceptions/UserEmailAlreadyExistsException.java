package com.example.learning.moviereview.user.exceptions;

public class UserEmailAlreadyExistsException extends Exception {
    public UserEmailAlreadyExistsException(String message) {
        super(message);
    }
}