package com.megala.inventorymanagement.dao;

import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.repository.InventoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.megala.inventorymanagement.util.TestHelper.createTestInventory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryDaoTest {

    InventoryDao inventoryDao = new InventoryDao();
    InventoryRepository inventoryRepository = mock(InventoryRepository.class);

    @BeforeEach
    void setUp() {
        inventoryDao.inventoryRepository = inventoryRepository;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInventoryMethodMustReturnInventoryForGivenItemId() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryRepository.findInventoryByItemId(itemId)).thenReturn(inventory);

        Inventory resultInventory = inventoryDao.getInventory(itemId);

        assertEquals(inventory, resultInventory);

        verify(inventoryRepository).findInventoryByItemId(itemId);
    }

    @Test
    void addInventoryMethodMustAddNewInventoryForGivenItemIdAndReturnInventory() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryRepository.addInventory(itemId, inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryDao.addInventory(itemId, inventory);

        assertEquals(inventory, resultInventory);

        verify(inventoryRepository).addInventory(itemId, inventory);
    }

    @Test
    void updateInventoryMethodMustUpdateInventoryForGivenITemIdAndReturnInventory() {
        Integer itemId = 3;
        Inventory inventory = createTestInventory();
        inventory.setItemId(3);

        when(inventoryRepository.updateInventory(itemId, inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryDao.updateInventory(itemId, inventory);

        assertEquals(inventory, resultInventory);

        verify(inventoryRepository).updateInventory(itemId, inventory);
    }

    @Test
    void removeInventoryMethodMustDeleteInventoryForGivenItemId() {
        Integer itemId = 3;

        inventoryDao.removeInventory(itemId);

        verify(inventoryRepository).deleteInventory(itemId);
    }
}