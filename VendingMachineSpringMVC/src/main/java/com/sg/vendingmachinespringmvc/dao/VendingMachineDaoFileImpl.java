/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<Integer, Item> items = new HashMap<>();

    @Override
    public Map<Integer, Item> getItems() {
        if (items.isEmpty()) {
            //Put some items to start with
            items.put(1, new Item(1, "Snickers", 4, BigDecimal.valueOf(1.99)));
            items.put(2, new Item(2, "Reeses", 6, BigDecimal.valueOf(2.99)));
            items.put(3, new Item(3, "Doritos", 2, BigDecimal.valueOf(1.99)));
            items.put(4, new Item(4, "Lindt", 5, BigDecimal.valueOf(1.99)));
            items.put(5, new Item(5, "Girardelli", 10, BigDecimal.valueOf(1.99)));
            items.put(6, new Item(6, "Oreos", 12, BigDecimal.valueOf(3.25)));
            items.put(7, new Item(7, "Lays", 7, BigDecimal.valueOf(2.69)));
            items.put(8, new Item(8, "Nachos", 10, BigDecimal.valueOf(1.99)));
            items.put(9, new Item(9, "Pringles", 8, BigDecimal.valueOf(3.99)));
        }
        return items;
    }

    @Override
    public Item getItem(int itemId) {
        return items.get(itemId);
    }

    @Override
    public void removeItem(int itemId) {
        Item item = getItem(itemId);

        //update quantity in map for this itemId
        int quantity = item.getQuantity();
        item.setQuantity(--quantity);
        items.put(itemId, item);
    }

}
