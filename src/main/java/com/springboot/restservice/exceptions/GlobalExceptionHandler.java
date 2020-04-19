package com.springboot.restservice.exceptions;
/*
@Author : Yogesh Deshmukh
*/

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;


/*It consist of all defined exception to be get updated with the ErrorResponse as per your need*/
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    //MethodArgumentNotValidException
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request){
    ErrorResponse errorResponse = new ErrorResponse(new Date(),"From MethodArgumentNotValid Exception", ex.getMessage());
    return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);

    }

    //HttpRequestMethodNotSupportedException
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        ErrorResponse errorResponse = new ErrorResponse(new Date(),"From HttpRequestMethodNotSupportedException Exception", ex.getMessage());
        return new ResponseEntity<Object>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);

    }

    //UserNameNotFoundException
    @ExceptionHandler(UserNameNotFoundException.class)
    public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,
                    WebRequest request){
            ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
    }

    //ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        ErrorResponse response = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

}
