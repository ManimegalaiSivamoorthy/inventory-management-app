package com.megala.inventorymanagement.dao;

import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryDao {
    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory getInventory(Integer itemId) {
        return inventoryRepository.findInventoryByItemId(itemId);
    }

    public Inventory addInventory(Integer itemId, Inventory inventory) {
        return inventoryRepository.addInventory(itemId, inventory);
    }

    public Inventory updateInventory(Integer itemId, Inventory inventory) {
        return inventoryRepository.updateInventory(itemId, inventory);
    }

    public void removeInventory(Integer itemId) {
        inventoryRepository.deleteInventory(itemId);
    }
}
