package com.megala.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ControllerAdvice
public class ResourceNotFound extends RuntimeException {
    String message;
    public ResourceNotFound () {}
    public ResourceNotFound (String message) {
        super(message);
        this.message = message;
    }
}

