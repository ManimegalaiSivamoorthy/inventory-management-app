package com.megala.inventorymanagement.controller;

import com.megala.inventorymanagement.exception.ResourceNotFound;
import com.megala.inventorymanagement.exception.UserNotAuthorized;
import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.rest.AuthClient;
import com.megala.inventorymanagement.service.AuthService;
import com.megala.inventorymanagement.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

import static com.megala.inventorymanagement.constant.AppConstant.CREATE_ITEM_ROLES;

@RestController
@RequestMapping("/inventory_management/v1")
public class ItemController {

    @Autowired ItemService itemService;
    @Autowired AuthService authService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(value = "/item", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@Valid @RequestBody Item item, @RequestParam("user_id") String userId) {
        logger.info(item.toString());
        if (!authService.validateUser(userId, CREATE_ITEM_ROLES)) {
            throw new UserNotAuthorized("User is not authorized to create item");
        }
        return itemService.createItem(item);
    }

    @GetMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") Integer id) {
        Item item = itemService.getItem(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/item/{id}")
    public Item putItem(@PathVariable("id") Integer id,@Valid @RequestBody Item item) {
        logger.info(item.toString());
        return itemService.updateItem(id, item);
    }

    @DeleteMapping(value = "/item/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        Item item = itemService.getItem(id);
        if (item == null) {
            throw new ResourceNotFound("Item is not available to delete.");
        }
        logger.info("Deleting item with id "+ id + " having data " + item);
        itemService.removeItem(id);
    }
}
