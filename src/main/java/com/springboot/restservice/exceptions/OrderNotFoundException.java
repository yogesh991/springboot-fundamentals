package com.springboot.restservice.exceptions;/* 
@Author : Yogesh Deshmukh
*/

public class OrderNotFoundException extends Exception{
    private static final Long serialVersionUID = 1L;
    private String message;

    public OrderNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
