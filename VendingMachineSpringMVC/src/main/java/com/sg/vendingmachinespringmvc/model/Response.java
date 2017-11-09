/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

/**
 *
 * @author asmat
 */
public class Response {
    
    String change;
    Item item;
    String message;
    boolean itemDispensed;

    public boolean isItemDispensed() {
        return itemDispensed;
    }

    public void setItemDispensed(boolean itemDispensed) {
        this.itemDispensed = itemDispensed;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
