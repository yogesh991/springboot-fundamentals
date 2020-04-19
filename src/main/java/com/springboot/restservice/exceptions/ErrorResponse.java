package com.springboot.restservice.exceptions;/* 
@Author : Yogesh Deshmukh
*/

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private String errorMessage;
    private String errorDetails;

    public ErrorResponse(Date timestamp, String errorMessage, String errorDetails) {
        super();
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "timestamp=" + timestamp +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorDetails='" + errorDetails + '\'' +
                '}';
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
