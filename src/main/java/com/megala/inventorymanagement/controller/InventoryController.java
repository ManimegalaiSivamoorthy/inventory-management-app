package com.megala.inventorymanagement.controller;

import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventory_management/v1")
public class InventoryController {
    @Autowired InventoryService inventoryService;
    Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/inventory/{item_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventory addInventory(@Valid @RequestBody Inventory inventory,
                                  @PathVariable("item_id") Integer itemId) {

        logger.info(inventory.toString());
        return inventoryService.addInventory(itemId, inventory);
    }

    @GetMapping(value = "/inventory/{item_id}")
    public ResponseEntity<Inventory> getInventory (@PathVariable("item_id") Integer itemId) {
        Inventory inventory = inventoryService.getInventory(itemId);
        if(inventory != null) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/inventory/{item_id}/on_hand/increment")
    public Inventory updateOnHandInventory(@PathVariable("item_id") Integer itemId) {
        return inventoryService.incrementOnHandInventory(itemId);
    }

    @PutMapping(value = "/inventory/{item_id}/on_arrival/increment")
    public Inventory updateOnArrivalInventory(@PathVariable("item_id") Integer itemId) {
        return inventoryService.incrementOnArrivalInventory(itemId);
    }

    @PutMapping("/inventory/{item_id}/on_order/increment")
    public Inventory updateOnOrderInventory (@PathVariable("item_id") Integer itemId) {
        return inventoryService.incrementOnOrderInventory(itemId);
    }

    @PutMapping(value = "/inventory/{item_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventory updateInventory(@PathVariable("item_id") Integer itemId, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(itemId, inventory);
    }

    @DeleteMapping(value = "/inventory/{item_id}")
    public void removeInventory(@PathVariable("item_id") Integer itemId) {
        logger.info(getInventory(itemId).toString());
        inventoryService.removeInventory(itemId);
    }
}
