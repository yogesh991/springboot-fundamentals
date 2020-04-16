package com.springboot.restservice.utils;

public class UserNotPresentException extends RuntimeException {
    private String message;

    public UserNotPresentException(String message) {
        super(message);
        this.message = message;
    }
}
