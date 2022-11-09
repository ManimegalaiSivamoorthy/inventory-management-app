package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.ItemDao;
import com.megala.inventorymanagement.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    /***
     * calls Dao method to create item
     * @param item
     * @return item object after the item is created
     */
    public Item createItem(Item item) {
        return itemDao.createItem(item);
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
        item.setId(itemId);
        return itemDao.updateItem(item);
    }

    /***
     * calls dao method to delete an item
     * @param itemId
     */
    public void removeItem(Integer itemId) {
        itemDao.deleteItem(itemId);
    }
}
