package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.InventoryDao;
import com.megala.inventorymanagement.exception.NotFoundException;
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

    /***
     * get inventory method calls inventory Dao to get an inventory for the given item id
     * @param itemId itemId
     * @return Inventory for the given item id
     */
    public Inventory getInventory(Integer itemId) {
        return inventoryDao.getInventory(itemId);
    }

    /***
     * add inventory method calls Dao to add an inventory for the given the item id
     * @param itemId itemId
     * @param inventory inventory
     * @return Inventory after adding inventory for the given id
     */
    public Inventory addInventory(Integer itemId, Inventory inventory) {
        return inventoryDao.addInventory(itemId, inventory);
    }

    /**
     * increment on hand inventory calls Dao to increment on hand inventory by 1
     * @param itemId itemId
     * @return Inventory after incrementing on hand inventory by 1
     */
    public Inventory incrementOnHandInventory(Integer itemId) {
        Inventory inventory = inventoryDao.getInventory(itemId);
        if (inventory == null) {
            throw new NotFoundException();
        }
        inventory.setOnHand(inventory.getOnHand() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    /**
     * increment on arrival inventory calls Dao to increment on arrival inventory by 1
     * @param itemId itemId
     * @return Inventory after incrementing on arrival inventory by 1
     */
    public Inventory incrementOnArrivalInventory(Integer itemId) {
        Inventory inventory = inventoryDao.getInventory(itemId);
        if (inventory == null) {
            throw new NotFoundException();
        }
        inventory.setOnArrival(inventory.getOnArrival() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    /**
     * increment on order inventory calls Dao to increment on order inventory by 1
     * @param itemId itemId
     * @return Inventory after incrementing on order inventory by 1
     */
    public Inventory incrementOnOrderInventory(Integer itemId) {
        logger.info("Starting to update Inventory for item {}", itemId);
        Inventory inventory = inventoryDao.getInventory(itemId);
        if (inventory == null) {
            throw new NotFoundException();
        }
        inventory.setOnOrder(inventory.getOnOrder() + 1);
        return inventoryDao.updateInventory(itemId, inventory);
    }

    /**
     * update inventory calls Dao to update the inventory for the given item id
     * @param itemId itemId
     * @param inventory inventory
     * @return Inventory after updating
     */
    public Inventory updateInventory(Integer itemId, Inventory inventory) {
        Inventory currentInventory = inventoryDao.getInventory(itemId);
        if (currentInventory == null) {
            throw new NotFoundException();
        }
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

    /**
     * remove inventory calls Dao to delete an inventory for the given item id
     * @param itemId itemId
     */
    public void removeInventory(Integer itemId) {
        inventoryDao.removeInventory(itemId);
    }
}
