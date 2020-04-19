package com.springboot.restservice.exceptions;/* 
@Author : Yogesh Deshmukh
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNameNotFoundException(UserNameNotFoundException ex){
        return new ErrorResponse(new Date(), "From RestController Advice", ex.getMessage());
    }
}
