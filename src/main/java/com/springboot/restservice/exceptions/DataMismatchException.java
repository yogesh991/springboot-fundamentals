package com.springboot.restservice.exceptions;
/*
@Author : Yogesh Deshmukh
*/

public class DataMismatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public DataMismatchException(String message) {
        super(message);
    }
}
