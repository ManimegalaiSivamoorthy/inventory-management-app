package com.megala.inventorymanagement.controller;

import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ItemControllerTest {

    @BeforeEach
    void setUp() {
        /*ItemController itemController = new ItemController();
        ItemService itemService = mock(ItemService.class);
        itemController.itemService = itemService;*/
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createItem() {
        //Setup
        ItemController itemController = new ItemController();
        ItemService itemService = mock(ItemService.class);
        itemController.itemService = itemService;
        Item item = new Item();
        item.setBrand("Dubagoor Brand");
        item.setSize(0.5);

        Item itemMockedResponse = new Item();
        itemMockedResponse.setId(5);
        itemMockedResponse.setBrand("Dubagoor Brand");
        itemMockedResponse.setSize(0.5);

        when(itemService.createItem(item)).thenReturn(itemMockedResponse);


        //Test
        Item result = itemController.createItem(item);

        //Verification
        assertNotNull(result.getId());
        assertEquals(5, result.getId());
        assertEquals(item.getBrand(), result.getBrand());
        assertEquals(item.getSize(), result.getSize());

        verify(itemService).createItem(item);
    }

    @Test
    void getItem() {
    }

    @Test
    void putItem() {
    }

    @Test
    void deleteItem() {
    }
}