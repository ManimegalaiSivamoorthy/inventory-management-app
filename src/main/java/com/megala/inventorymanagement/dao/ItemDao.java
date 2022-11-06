package com.megala.inventorymanagement.dao;

import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDao {
    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.addItem(item);
    }

    public Item updateItem(Item item) {
        return itemRepository.updateItem(item.getId(), item);
    }

    public Item getItem(Integer itemId) {
        return itemRepository.findByItemId(itemId);
    }

    public void deleteItem(Integer itemId) {
        itemRepository.deleteItem(itemId);
    }
}
