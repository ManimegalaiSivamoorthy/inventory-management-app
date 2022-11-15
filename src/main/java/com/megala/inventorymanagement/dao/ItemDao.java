package com.megala.inventorymanagement.dao;

import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDao {
    @Autowired
    ItemRepository itemRepository;

    /***
     * calls itemRepository to create an item
     * @param item
     * @return item object after creating an item
     */
    public Item createItem(Item item){
        itemRepository.addItem(item);
        return itemRepository.findByItemId(item.getId());
    }

    /***
     * calls item Repository to get an item
     * @param itemId
     * @return item object for the given item id
     */
    public Item getItem(Integer itemId) {
        return itemRepository.findByItemId(itemId);
    }

    /***
     * calls itemRepository to update an item
     * @param item
     * @return item object after updating an item for the given item id
     */
    public Item updateItem(Item item) {
        itemRepository.updateItem(item.getId(), item);
        return itemRepository.findByItemId(item.getId());
    }

    /***
     * calls itemRepository to delete an item
     * @param itemId
     */
    public void deleteItem(Integer itemId) {
        itemRepository.deleteItem(itemId);
    }
}
