package com.megala.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Item {
    Integer id;
    @NotNull
    String description;
    String brand;
    @DecimalMin(value = "0.01", message = "Cost cannot be less then 1 cent")
    Double cost;
    Double size;
    String sizeUnit;
    @Min(value = 1, message = "The item quantity should be atleast 1")
    Integer packageQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                ", size=" + size +
                ", sizeUnit='" + sizeUnit + '\'' +
                ", packageQuantity=" + packageQuantity +
                '}';
    }
}
