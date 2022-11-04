package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Inventory;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class InventoryRepository {
    HashMap<Integer, Inventory> inventoryDatabase = new HashMap<>();

    public Inventory findInventoryByItemId(Integer itemId) {
        return inventoryDatabase.get(itemId);
    }

    public Inventory addInventory(Integer itemId, Inventory inventory) {
        inventory.setItemId(itemId);
        inventoryDatabase.put(itemId, inventory);
        return inventoryDatabase.get(itemId);
    }

    public Inventory updateInventory(Integer itemId,Inventory inventory) {
        return inventoryDatabase.put(itemId, inventory);
    }


    public void deleteInventory(Integer itemId) {
        inventoryDatabase.remove(itemId);
    }
}
