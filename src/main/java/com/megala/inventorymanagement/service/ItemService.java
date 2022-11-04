package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.ItemDao;
import com.megala.inventorymanagement.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    public Item createItem(Item item) {
        return itemDao.createItem(item);
    }

    public Item getItem(Integer itemId) {
        return itemDao.getItem(itemId);
    }

    public void updateItem(Integer itemId, Item item) {
        item.setId(itemId);
        itemDao.updateItem(item);
    }

    public void removeItem(Integer itemId) {
        itemDao.deleteItem(itemId);
    }
}
