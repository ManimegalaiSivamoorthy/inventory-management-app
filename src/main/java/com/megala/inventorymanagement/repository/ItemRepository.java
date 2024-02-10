package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Item;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ItemRepository {
    @Select("select item_id as id, " +
            "       description, " +
            "       brand, " +
            "       cost, " +
            "       size, " +
            "       size_unit as sizeUnit, " +
            "       package_quantity as packageQuantity " +
            "  from item " +
            " where item_id = #{itemId}")
    Item findByItemId(Integer itemId);

    @Insert("INSERT into item (item_id, description, brand, cost, size, size_unit, package_quantity)" +
            "values (#{id}, #{description}, #{brand}, #{cost}, #{size}, #{sizeUnit}, #{packageQuantity})"
    )
    void addItem(Item item);

    @Update("UPDATE item " +
            "   set description = #{item.description}, " +
            "   brand = #{item.brand}, " +
            "   cost = #{item.cost}, " +
            "   size = #{item.size}, " +
            "   size_unit = #{item.sizeUnit}, " +
            "   package_quantity = #{item.packageQuantity} " +
            " where item_id = #{itemId}")
    void updateItem(Integer itemId, Item item);

    @Delete("delete from item where item_id = #{itemId}")
    void deleteItem(Integer itemId);
}
