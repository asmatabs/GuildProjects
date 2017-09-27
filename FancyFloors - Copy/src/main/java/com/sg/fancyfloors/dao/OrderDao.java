/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface OrderDao {
    
    int getNextOrderNumber();
    Order getOrderByOrderNumber(int orderNum);
    List<Order> getOrdersByCustomerName(String customerName);
    List<Order> getOrdersByDate(LocalDate orderDate);
    List<Order> getOrdersByProductType(String productType);
    
    void addNewOrder(Order newOrder);
}
