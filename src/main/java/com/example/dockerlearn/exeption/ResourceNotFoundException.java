package com.example.dockerlearn.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this("User not found!");
    }

    public ResourceNotFoundException(String message) {
        this(message, (Throwable) null);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}