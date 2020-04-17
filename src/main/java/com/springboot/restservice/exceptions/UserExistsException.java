package com.springboot.restservice.exceptions;


/*
@Author : Yogesh Deshmukh
*/
public class UserExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    private String message;

    public UserExistsException(String message) {
        super(message);
        this.message = message;
    }
}
