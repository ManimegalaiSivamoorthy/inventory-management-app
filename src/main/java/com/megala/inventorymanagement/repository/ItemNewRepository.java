package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemNewRepository {
    @Select("select ")
    Item findByItemId(Integer itemId);

    Item addItem(Item item);

    Item updateItem(Integer itemId, Item item);

    void deleteItem(Integer itemId);
}
