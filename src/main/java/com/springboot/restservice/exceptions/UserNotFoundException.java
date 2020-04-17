package com.springboot.restservice.exceptions;

/*
@Author : Yogesh Deshmukh
*/
public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
