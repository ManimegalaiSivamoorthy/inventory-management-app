package com.megala.inventorymanagement.dao;

import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.megala.inventorymanagement.util.TestHelper.createTestItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemDaoTest {

    ItemDao itemDao = new ItemDao();
    ItemRepository itemRepository = mock(ItemRepository.class);

    @BeforeEach
    void setUp() {
        itemDao.itemRepository = itemRepository;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createItem() {
        Item item = createTestItem();
        Item createdItem = createTestItem();

        when(itemRepository.addItem(item)).thenReturn(createdItem);

        Item resultItem = itemDao.createItem(item);

        assertEquals(createdItem, resultItem);

        verify(itemRepository).addItem(item);
    }

    @Test
    void updateItem() {
        Item item = createTestItem();
        Integer itemId = item.getId();
        Item newUpdatedItem = createTestItem();

        when(itemRepository.updateItem(itemId, item)).thenReturn(newUpdatedItem);

        Item resultItem = itemDao.updateItem(item);

        assertEquals(newUpdatedItem, resultItem);

        verify(itemRepository).updateItem(itemId, item);
    }

    @Test
    void getItem() {
        Integer itemId = 4;
        Item item = createTestItem();
        item.setId(4);

        when(itemRepository.findByItemId(itemId)).thenReturn(item);

        Item resultItem = itemDao.getItem(itemId);

        assertEquals(item, resultItem);

        verify(itemRepository).findByItemId(itemId);
    }

    @Test
    void deleteItem() {
        Integer itemId = 3;

        itemDao.deleteItem(itemId);

        verify(itemRepository).deleteItem(itemId);
    }
}