package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.dao.ItemDao;
import com.megala.inventorymanagement.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.megala.inventorymanagement.util.TestHelper.createTestItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    ItemService itemService = new ItemService();
    ItemDao itemDao = mock(ItemDao.class);

    @BeforeEach
    void setUp() {
        itemService.itemDao = itemDao;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createItem() {
        Item item = createTestItem();
        Item createdItem = createTestItem();

        when(itemDao.createItem(item)).thenReturn(createdItem);

        Item resultItem = itemService.createItem(item);

        assertEquals(createdItem, resultItem);

        verify(itemDao).createItem(item);
    }

    @Test
    void getItem() {
        Integer itemId = 2;
        Item item = createTestItem();
        item.setId(2);

        when(itemDao.getItem(itemId)).thenReturn(item);

        Item resultItem = itemService.getItem(itemId);

        assertEquals(item, resultItem);

        verify(itemDao).getItem(itemId);
    }

    @Test
    void updateItem() {
        Item item = createTestItem();
        Integer itemId = 5;
        item.setId(itemId);
        Item newUpdatedItem = createTestItem();
        newUpdatedItem.setId(itemId);

        when(itemDao.updateItem(item)).thenReturn(newUpdatedItem);

        Item resultItem = itemService.updateItem(itemId, item);

        assertEquals(newUpdatedItem, resultItem);

        verify(itemDao).updateItem(item);
    }

    @Test
    void removeItem() {
        Integer itemId = 3;

        itemService.removeItem(itemId);

        verify(itemDao).deleteItem(itemId);
    }
}