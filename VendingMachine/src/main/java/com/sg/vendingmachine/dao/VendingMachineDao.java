/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asmat
 */
public interface VendingMachineDao {
    
    Map<String, List<Item>> getItems();
            
    Item getItem(String name);
    
    ItemPrice getItemPrice(int option);
    
    void loadInventory() throws VMPersistenceException;
    
    void loadPricingInfo() throws VMPersistenceException;
    
    void updateInventory() throws VMPersistenceException;
    
    Map<String, BigDecimal> getItemsWithPrices();

    void removeItem(Item item);
}
