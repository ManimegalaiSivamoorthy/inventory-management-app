package com.megala.inventorymanagement.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.Min;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Inventory {
    Integer itemId;
    @Min(value = 1, message = "The item on hand should be atleast 1")
    Integer onHand;
    Integer onArrival;
    Integer onOrder;
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public Integer getOnHand() {
        return onHand;
    }

    public void setOnHand(Integer onHand) {
        this.onHand = onHand;
    }

    public Integer getOnArrival() {
        return onArrival;
    }

    public void setOnArrival(Integer onArrival) {
        this.onArrival = onArrival;
    }

    public Integer getOnOrder() {
        return onOrder;
    }

    public void setOnOrder(Integer onOrder) {
        this.onOrder = onOrder;
    }

    @Override
    public String toString() {
        return "InventoryDetails{" +
                "onHand=" + onHand +
                ", onArrival=" + onArrival +
                ", onOrder=" + onOrder +
                '}';
    }
}
