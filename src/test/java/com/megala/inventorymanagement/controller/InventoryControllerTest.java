package com.megala.inventorymanagement.controller;

import com.megala.inventorymanagement.model.Inventory;
import com.megala.inventorymanagement.service.InventoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.megala.inventorymanagement.util.TestHelper.createTestInventory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryControllerTest {
    InventoryController inventoryController = new InventoryController();
    InventoryService inventoryService = mock(InventoryService.class);

    @BeforeEach
    void setUp() {
        inventoryController.inventoryService = inventoryService;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addInventoryMethodMustAddInventoryAndReturnAddedInventory() {
        Integer itemId = 1;
        Inventory inventory = createTestInventory();
        Inventory mockedAddInventory = createTestInventory();

        when(inventoryService.addInventory(itemId, inventory)).thenReturn(mockedAddInventory);

        Inventory resultInventory = inventoryController.addInventory(inventory, itemId);

        assertEquals(mockedAddInventory, resultInventory);

        verify(inventoryService, times(1)).addInventory(itemId, inventory);

    }

    @Test
    void getInventoryMethodMustGetInventoryUsingItemIdAndReturnHttpStatusOk() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryService.getInventory(itemId)).thenReturn(inventory);

        ResponseEntity<Inventory> response = inventoryController.getInventory(itemId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(inventory, response.getBody());

        verify(inventoryService).getInventory(itemId);
    }

    @Test
    void getInventoryMethodMustGetInventoryUsingItemIdAndReturnHttpStatusNotFound() {
        Integer itemId = 2;

        when(inventoryService.getInventory(itemId)).thenReturn(null);

        ResponseEntity<Inventory> response = inventoryController.getInventory(itemId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        verify(inventoryService).getInventory(itemId);
    }

    @Test
    void updateOnHandInventoryMethodMustUpdateOnHandInventoryForGivenItemId() {
        Integer itemId = 3;

        Inventory mockedInventory = createTestInventory();
        mockedInventory.setItemId(3);
        mockedInventory.setOnHand(10);

        when(inventoryService.incrementOnHandInventory(itemId)).thenReturn(mockedInventory);

        Inventory updatedOnHandInventory = inventoryController.updateOnHandInventory(itemId);

        assertEquals(mockedInventory, updatedOnHandInventory);

        verify(inventoryService).incrementOnHandInventory(itemId);
    }

    @Test
    void updateOnArrivalInventoryMethodMustUpdateOnArrivalInventoryForGivenItemId() {
        Integer itemId = 3;

        Inventory mockedInventory = createTestInventory();
        mockedInventory.setItemId(3);
        mockedInventory.setOnArrival(10);

        when(inventoryService.incrementOnArrivalInventory(itemId)).thenReturn(mockedInventory);

        Inventory updatedOnArrivalInventory = inventoryController.updateOnArrivalInventory(itemId);

        assertEquals(mockedInventory, updatedOnArrivalInventory);

        verify(inventoryService).incrementOnArrivalInventory(itemId);
    }

    @Test
    void updateOnOrderInventoryMethodMustUpdateOnOrderInventoryForGivenItemId() {
        Integer itemId = 3;

        Inventory mockedInventory = createTestInventory();
        mockedInventory.setItemId(3);
        mockedInventory.setOnArrival(10);

        when(inventoryService.incrementOnOrderInventory(itemId)).thenReturn(mockedInventory);

        Inventory updatedOnOrderInventory = inventoryController.updateOnOrderInventory(itemId);

        assertEquals(mockedInventory, updatedOnOrderInventory);

        verify(inventoryService).incrementOnOrderInventory(itemId);
    }

    @Test
    void updateInventoryMethodMustUpdateInventoryForGivenItemIdAndReturnInventory() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryService.updateInventory(itemId, inventory)).thenReturn(inventory);

        Inventory resultInventory = inventoryController.updateInventory(itemId, inventory);

        assertEquals(inventory, resultInventory);

        verify(inventoryService).updateInventory(itemId, inventory);
    }

    @Test
    void removeInventoryMethodMustDeleteInventoryForGivenItemId() {
        Integer itemId = 2;
        Inventory inventory = createTestInventory();
        inventory.setItemId(2);

        when(inventoryService.getInventory(itemId)).thenReturn(inventory);

        inventoryController.removeInventory(itemId);

        verify(inventoryService).removeInventory(itemId);
    }
}