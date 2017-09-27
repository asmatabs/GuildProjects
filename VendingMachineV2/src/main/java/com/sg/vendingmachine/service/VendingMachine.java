/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.FilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public interface VendingMachine {

    Item vendItem(String item, Money money)
            throws NoItemInventoryException, InsufficientFundsException, FilePersistenceException;

    void initializeInventory() throws FilePersistenceException;

    Map<String, BigDecimal> getItemsWithPrices();

    boolean validatePayment(Money money);

    Money dispenseChange(Money money, boolean itemPurchased);
}
