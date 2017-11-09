/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringspringmvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asmat
 */
public class OrderResponse {
    
    List<String> messages = new ArrayList<>();
    List<Order> orders; 
    boolean orderPlaced;

    public List<String> getMessage() {
        return messages;
    }

    public void setMessage(String message) {
        this.messages.add(message);
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    @Override
    public String toString() {
        return "OrderResponse{" + "messages=" + messages + ", order=" + orders + ", orderPlaced=" + orderPlaced + '}';
    }
}
