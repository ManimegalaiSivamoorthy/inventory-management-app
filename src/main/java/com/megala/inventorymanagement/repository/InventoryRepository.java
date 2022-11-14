package com.megala.inventorymanagement.repository;

import com.megala.inventorymanagement.model.Inventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InventoryRepository {

    @Select("select item_id as itemId, " +
            "  on_hand as onHand, " +
            "  on_arrival as onArrival, " +
            "  on_order as onOrder " +
            "from inventory " +
            "where item_id = #{itemId}")
    Inventory findInventoryByItemId(Integer itemId);

    @Insert("Insert into inventory (item_id, on_hand, on_arrival, on_order) values (#{itemId} , #{onHand} , #{onArrival} , #{onOrder})")
    void addInventory(Inventory inventory);

    @Update("update inventory set item_id = #{itemId}, on_hand = #{onHand}, on_arrival = #{onArrival}, on_order = #{onOrder} where item_id = #{itemId}")
    void updateInventory(Inventory inventory);

    @Delete("delete from inventory where item_id = #{itemId}")
    void deleteInventory(Integer itemId);
}
