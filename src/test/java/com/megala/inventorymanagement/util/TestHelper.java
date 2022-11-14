package com.megala.inventorymanagement.util;

import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.model.Item;

public class TestHelper {
    public static Item createTestItem() {
        Item item = new Item();
        item.setId(1);
        item.setDescription("pencil");
        item.setBrand("HB");
        item.setCost(0.3);
        item.setPackageQuantity(12);
        return item;
    }

    public static Inventory createTestInventory() {
        Inventory inventory = new Inventory();
        inventory.setItemId(1);
        inventory.setOnOrder(2);
        inventory.setOnArrival(4);
        inventory.setOnHand(5);
        return inventory;
    }
}
