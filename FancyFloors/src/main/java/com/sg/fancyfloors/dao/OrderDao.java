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
    
    public void initialize() throws FilePersistenceException;

    int getNextOrderNumber();
    List<Order> getOrderByDateAndOrderNumber(LocalDate date, int orderNum) throws FilePersistenceException ;
    List<Order> getOrdersByDateAndCustomerName(LocalDate date, String customerName) throws FilePersistenceException ;
    List<Order> getOrdersByDate(LocalDate orderDate) throws FilePersistenceException ;
    
    void addNewOrder(Order newOrder);

    void removeOrder(LocalDate orderDate, Order orderToRemove) throws FilePersistenceException;
    
    void save() throws FilePersistenceException;
}
