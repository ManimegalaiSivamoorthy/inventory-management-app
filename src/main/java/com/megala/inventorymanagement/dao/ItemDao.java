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
        itemRepository.addItem(item);
        return itemRepository.findByItemId(item.getId());
    }

    public Item updateItem(Item item) {
        itemRepository.updateItem(item.getId(), item);
        return itemRepository.findByItemId(item.getId());
    }

    public Item getItem(Integer itemId) {
        return itemRepository.findByItemId(itemId);
    }

    public void deleteItem(Integer itemId) {
        itemRepository.deleteItem(itemId);
    }
}
