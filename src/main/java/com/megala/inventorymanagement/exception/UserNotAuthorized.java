package com.megala.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
@ControllerAdvice
public class UserNotAuthorized extends RuntimeException {
    String message;
    public UserNotAuthorized() {}
    public UserNotAuthorized(String message) {
        super(message);
        this.message = message;
    }
}

