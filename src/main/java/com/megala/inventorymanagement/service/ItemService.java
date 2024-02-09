package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.controller.ItemController;
import com.megala.inventorymanagement.dao.ItemDao;
import com.megala.inventorymanagement.exception.ItemAlreadyExist;
import com.megala.inventorymanagement.exception.ResourceNotFound;
import com.megala.inventorymanagement.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    Logger logger = LoggerFactory.getLogger(ItemService.class);

    /***
     * calls Dao method to create item
     * @param item
     * @return item object after the item is created
     */
    public Item createItem(Item item) {
        if (IsExistingItemId(item))
            throw new ItemAlreadyExist("Selected Item ID is already used. Please select a different ID");
        return itemDao.createItem(item);
    }

    private boolean IsExistingItemId(Item item) {
        Item selectedItem = itemDao.getItem(item.getId());
        return selectedItem != null;
    }

    /***
     * calls Dao method to get an item
     * @param itemId
     * @return item object for the given item id
     */
    public Item getItem(Integer itemId) {
        return itemDao.getItem(itemId);
    }

    /***
     * calls DAo method to update an item
     * @param itemId
     * @param item
     * @return item object after the item is updated
     */
    public Item updateItem(Integer itemId, Item item) {
        Item oldItem = itemDao.getItem(itemId);
        if (oldItem == null) {
            throw new ResourceNotFound("Item is not available to update!");
        }
        item.setId(itemId);
        return itemDao.updateItem(item);
    }

    /***
     * calls dao method to delete an item
     * @param itemId
     */
    public void removeItem(Integer itemId) {
        Item item = itemDao.getItem(itemId);
        if (item == null) {
            throw new ResourceNotFound("Item to be deleted is not found!");
        }
        logger.info("Deleting item with id "+ itemId + " having data " + item);
        itemDao.deleteItem(itemId);
    }
}
