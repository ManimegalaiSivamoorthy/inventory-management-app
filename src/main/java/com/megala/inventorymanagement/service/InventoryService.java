package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.InventoryDao;
import com.megala.inventorymanagement.model.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    InventoryDao inventoryDao;

    public Inventory getInventory(Integer itemId) {
        return inventoryDao.getInventory(itemId);
    }

    public Inventory addInventory(Integer itemId, Inventory inventory) {
        return inventoryDao.addInventory(itemId, inventory);
    }

    public Inventory incrementOnHandInventory(Integer itemId) {
        Inventory inventory = inventoryDao.getInventory(itemId);
        inventory.setOnHand(inventory.getOnHand() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    public Inventory incrementOnArrivalInventory(Integer itemId) {
        Inventory inventory = inventoryDao.getInventory(itemId);
        inventory.setOnArrival(inventory.getOnArrival() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    public Inventory incrementOnOrderInventory(Integer itemId) {
        Inventory inventory = inventoryDao.getInventory(itemId);
        inventory.setOnOrder(inventory.getOnOrder() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    public Inventory updateInventory(Integer itemId, Inventory inventory) {
        Inventory currentInventory = inventoryDao.getInventory(itemId);
        if (inventory.getOnHand() != null) {
            currentInventory.setOnHand(inventory.getOnHand());
        } else {
            logger.info("On hand inventory update skipped for item {} since new value passed is null ", itemId);
        }
        if(inventory.getOnArrival() != null) {
            currentInventory.setOnArrival(inventory.getOnArrival());
        } else {
            logger.info("On hand inventory update skipped for item {} since new value passed is null ", itemId);
        }
        if (inventory.getOnOrder() != null) {
            currentInventory.setOnOrder(inventory.getOnOrder());
        }else {
            logger.info("On hand inventory update skipped for item {} since new value passed is null ", itemId);
        }
        return inventoryDao.updateInventory(itemId, currentInventory);
    }

    public void removeInventory(Integer itemId) {
        inventoryDao.removeInventory(itemId);
    }
}
