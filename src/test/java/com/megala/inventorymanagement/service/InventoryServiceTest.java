package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.InventoryDao;
import com.megala.inventorymanagement.exception.ResourceNotFound;
import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.megala.inventorymanagement.util.TestHelper.createTestInventory;
import static com.megala.inventorymanagement.util.TestHelper.createTestItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    InventoryService inventoryService = new InventoryService();
    InventoryDao inventoryDao = mock(InventoryDao.class);
    ItemService itemService = mock(ItemService.class);


    @BeforeEach
    void setUp() {
        inventoryService.inventoryDao = inventoryDao;
        inventoryService.itemService = itemService;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInventoryMethodReturnInventoryForTheGivenITemId() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryDao.getInventory(itemId)).thenReturn(inventory);

        Inventory resultInventory = inventoryService.getInventory(itemId);

        assertEquals(inventory, resultInventory);

        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void addInventoryMethodMustAddInventoryForTheGivenItemIdReturnsInventory() {
        Integer itemId = 3;
        Inventory inventory = createTestInventory();
        inventory.setItemId(3);
        Item item = createTestItem();
        item.setId(3);

        when(itemService.getItem(itemId)).thenReturn(item);

        when(inventoryDao.addInventory(itemId, inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryService.addInventory(itemId, inventory);

        assertEquals(inventory, resultInventory);

        verify(inventoryDao).addInventory(itemId, inventory);
        verify(itemService).getItem(itemId);
    }

    @Test
    void addInventoryMethodThrowsExceptionWhenItemIsNotAvailable() {
        Integer itemId = 3;
        Inventory inventory = createTestInventory();
        inventory.setItemId(3);
        Item item = createTestItem();
        item.setId(3);

        assertThrows(ResourceNotFound.class, () -> inventoryService.addInventory(itemId, inventory));

        verify(itemService).getItem(itemId);
    }

    @Test
    void incrementOnHandInventoryMethodMustIncrementAndReturnUpdatedInventory() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryDao.getInventory(itemId)).thenReturn(inventory);
        when(inventoryDao.updateInventory(itemId,inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryService.incrementOnHandInventory(itemId);

        assertEquals(inventory, resultInventory);

        verify(inventoryDao).updateInventory(itemId, inventory);
        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void incrementOnHandInventoryMethodMustThrowExceptionWhenInventoryIsNotFound() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        assertThrows(ResourceNotFound.class, () -> inventoryService.incrementOnHandInventory(itemId));

        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void incrementOnArrivalInventoryMustIncrementAndReturnUpdatedInventory() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryDao.getInventory(itemId)).thenReturn(inventory);
        when(inventoryDao.updateInventory(itemId,inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryService.incrementOnArrivalInventory(itemId);

        assertEquals(inventory, resultInventory);

        verify(inventoryDao).updateInventory(itemId, inventory);
        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void incrementOnArrivalInventoryMethodMustThrowExceptionWhenInventoryIsNotFound() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        assertThrows(ResourceNotFound.class, () -> inventoryService.incrementOnArrivalInventory(itemId));

        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void incrementOnOrderInventoryMustIncrementAndReturnUpdatedInventory() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryDao.getInventory(itemId)).thenReturn(inventory);
        when(inventoryDao.updateInventory(itemId,inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryService.incrementOnOrderInventory(itemId);

        assertEquals(inventory, resultInventory);

        verify(inventoryDao).updateInventory(itemId, inventory);
        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void incrementOnOrderInventoryMethodMustThrowExceptionWhenInventoryIsNotFound() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        assertThrows(ResourceNotFound.class, () -> inventoryService.incrementOnOrderInventory(itemId));

        verify(inventoryDao).getInventory(itemId);
    }


    @Test
    void updateInventoryMethodMustUpdateInventoryBasedOnTheInput() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setOnOrder(10);
        inventory.setOnArrival(15);
        inventory.setOnHand(20);
        inventory.setItemId(2);

        Inventory currentInventory = createTestInventory();

        Inventory updatedInventory = createTestInventory();

        when(inventoryDao.getInventory(itemId)).thenReturn(currentInventory);
        when(inventoryDao.updateInventory(itemId, currentInventory)).thenReturn(updatedInventory);

        Inventory result = inventoryService.updateInventory(itemId, inventory);

        verify(inventoryDao).getInventory(itemId);
        verify(inventoryDao).updateInventory(itemId, currentInventory);

        assertEquals(currentInventory.getOnArrival(), inventory.getOnArrival());
        assertEquals(updatedInventory, result);
    }

    @Test
    void updateInventoryMethodMustThrowExceptionWhenInventoryIsNotAvailable() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        assertThrows(ResourceNotFound.class, () -> inventoryService.updateInventory(itemId, inventory));

        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void removeInventoryMustDeleteInventoryForGivenItemId() {
        Integer itemId = 1;
        Inventory inventory = createTestInventory();
        inventory.setItemId(1);

        when(inventoryDao.getInventory(itemId)).thenReturn(inventory);
        inventoryService.removeInventory(itemId);

        verify(inventoryDao).removeInventory(itemId);
        verify(inventoryDao).getInventory(itemId);
    }

    @Test
    void removeInventoryMustThrowExceptionWhenInventoryIsNotAvailable() {
        Integer itemId = 1;

        assertThrows(ResourceNotFound.class, () -> inventoryService.removeInventory(itemId));

        verify(inventoryDao).getInventory(itemId);
    }
}