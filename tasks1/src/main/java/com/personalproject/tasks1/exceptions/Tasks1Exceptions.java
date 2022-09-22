package com.personalproject.tasks1.exceptions;

import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class Tasks1Exceptions extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;
    
    public Tasks1Exceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
