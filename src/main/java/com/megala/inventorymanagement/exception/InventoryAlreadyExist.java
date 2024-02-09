package com.megala.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ControllerAdvice
public class InventoryAlreadyExist extends RuntimeException {
    String message;
    public InventoryAlreadyExist() {}
    public InventoryAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
}
