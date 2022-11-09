package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ItemRepository {
    HashMap<Integer, Item> itemDatabase = new HashMap<>();

    Integer id = 0;

    /***
     * This method is used to generate item id
     * @return incremented id
     */
    public Integer getNextId() {
        return ++id;
    }

    /***
     * This method gets an item for the given item id
     * @param itemId
     * @return item object for the given item id
     */
    public Item findByItemId(Integer itemId) {
        return itemDatabase.get(itemId);
    }

    /***
     * Add item method create an item for the item id given
     * @param item
     * @return item object after creating an item using findByITemId method
     */
    public Item addItem(Item item){
        Integer id = getNextId();
        item.setId(id);
        itemDatabase.put(id, item);
        return findByItemId(id);
    }

    /***
     * This method updates an item
     * @param itemId
     * @param item
     * @return updated item object
     */
    public Item updateItem(Integer itemId, Item item) {
        item.setId(itemId);
        return itemDatabase.put(itemId, item);
    }

    /***
     * This method delete the item for the given item id
     * @param itemId
     */
    public void deleteItem(Integer itemId) {
        itemDatabase.remove(itemId);
    }
}
