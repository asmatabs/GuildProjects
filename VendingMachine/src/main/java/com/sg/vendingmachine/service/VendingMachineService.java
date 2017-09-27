/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public interface VendingMachineService {

    Item getItemFromInventory(int option, Money money)
            throws VMNoItemInventoryException, VMInsufficientFundsException, VMPersistenceException;

    void initializeInventory() throws VMPersistenceException;

    Map<String, BigDecimal> getItemsWithPrices();

    boolean validatePayment(Money money);

    Money calculateChange(Money money);
}
