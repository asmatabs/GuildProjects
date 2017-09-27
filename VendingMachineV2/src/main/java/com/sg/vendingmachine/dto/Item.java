/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author asmat
 */
public class Item {

    String itemId;
    String name;
    LocalDate manufacturerDate;
    String nutriInfo;

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturerDate(LocalDate manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public void setNutriInfo(String nutriInfo) {
        this.nutriInfo = nutriInfo;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getManufacturerDate() {
        return manufacturerDate;
    }

    public String getNutriInfo() {
        return nutriInfo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.itemId);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.manufacturerDate);
        hash = 67 * hash + Objects.hashCode(this.nutriInfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.nutriInfo, other.nutriInfo)) {
            return false;
        }
        if (!Objects.equals(this.manufacturerDate, other.manufacturerDate)) {
            return false;
        }
        return true;
    }
    
        @Override
    public String toString() {
        return "Item ID: " + itemId + " | Name: " + name;
    }
}
