package com.megala.inventorymanagement.controller;

import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.megala.inventorymanagement.util.TestHelper.createTestItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemControllerTest {

    ItemController itemController = new ItemController();
    ItemService itemService = mock(ItemService.class);

    @BeforeEach
    void setUp() {
        itemController.itemService = itemService;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createItemMethodMustCreateItemAndReturnTheCreatedItem() {
        Item item = createTestItem();

        when(itemService.createItem(item)).thenReturn(item);

        Item result = itemController.createItem(item);

        assertNotNull(result.getId());
        assertEquals(1, result.getId());
        assertEquals(item.getBrand(), result.getBrand());
        assertEquals(item.getSize(), result.getSize());

        verify(itemService, times(1)).createItem(item);
    }

    @Test
    void getItemMethodMustGetITemAndReturnITemAndHttpStatusOK() {
        Item item = createTestItem();

        when(itemService.getItem(1)).thenReturn(item);

        ResponseEntity<Item> response = itemController.getItem(1);
        verify(itemService, times(1)).getItem(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(item, response.getBody());
    }
    @Test
    void getItemMethodMustReturnHttpStatusNotFoundWhenItemIsNotFound() {
        when(itemService.getItem(1)).thenReturn(null);

        ResponseEntity<Item> response = itemController.getItem(1);
        verify(itemService, times(1)).getItem(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void updateItemMethodMustUpdateAndReturnUpdatedItem() {
        Item item = createTestItem();

        Item updatedItemMockedResponse = createTestItem();
        updatedItemMockedResponse.setBrand("camlin");

        when(itemService.updateItem(item.getId(), item)).thenReturn(updatedItemMockedResponse);

        Item result = itemController.putItem(item.getId(), item);

        verify(itemService, times(1)).updateItem(item.getId(), item);
        assertEquals(result, updatedItemMockedResponse);
    }

    @Test
    void deleteItemMethodShouldDeleteItem() {
        Item item = createTestItem();

        when(itemService.getItem(1)).thenReturn(item);

        itemController.deleteItem(1);
        verify(itemService, times(1)).removeItem(1);
    }
}