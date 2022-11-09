package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ItemRepository {
    HashMap<Integer, Item> itemDatabase = new HashMap<>();

    Integer id = 0;

    public Integer getNextId() {
        return ++id;
    }

    public Item findByItemId(Integer itemId) {
        return itemDatabase.get(itemId);
    }

    public Item addItem(Item item){
        Integer id = getNextId();
        item.setId(id);
        itemDatabase.put(id, item);
        return findByItemId(id);
    }

    public Item updateItem(Integer itemId, Item item) {
        item.setId(itemId);
        itemDatabase.put(itemId, item);
        return itemDatabase.get(itemId);
    }

    public void deleteItem(Integer itemId) {
        itemDatabase.remove(itemId);
    }
}
