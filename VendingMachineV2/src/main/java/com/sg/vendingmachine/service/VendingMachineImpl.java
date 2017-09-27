/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import com.sg.vendingmachine.dto.Money;
import com.sg.vendingmachine.dao.ItemsDao;
import com.sg.vendingmachine.dao.FilePersistenceException;
import java.math.BigDecimal;
import java.util.Map;
/**
 *
 * @author asmat
 */
public class VendingMachineImpl implements VendingMachine {

    ItemsDao dao;
    ItemPrice itemPrice;

    public VendingMachineImpl(ItemsDao dao) {
        this.dao = dao;
    }

    @Override
    public Item vendItem(String itemName, Money money)
            throws NoItemInventoryException, InsufficientFundsException, FilePersistenceException {
        itemPrice = dao.getItemPrice(itemName);
        
        if (itemPrice.getPrice().compareTo(money.getTotalAmount()) == 1) {
            throw new InsufficientFundsException("LOOKS LIKE YOU DO NOT HAVE ENOUGH FUNDS");
        }
        Item item = dao.getItem(itemName);
        if (item == null) {
            throw new NoItemInventoryException("SORRY! SOLD OUT ON THIS ITEM");
        }

        dao.removeItem(item);
        dao.updateInventory();

        return item;
    }

    @Override
    public void initializeInventory() throws FilePersistenceException {
        dao.loadInventory();
        dao.loadPricingInfo();
    }

    @Override
    public Map<String, BigDecimal> getItemsWithPrices() {
        return dao.getItemsWithPrices();
    }

    @Override
    public boolean validatePayment(Money money) {

        return money.getTotalAmount().intValue() > 0;
    }

    @Override
    public Money dispenseChange(Money money, boolean itemPurchased) {

        BigDecimal amtDue;
        if (itemPurchased && itemPrice != null) {
            amtDue = money.getTotalAmount().subtract(itemPrice.getPrice());
        } else {
            amtDue = money.getTotalAmount();
        }

        BigDecimal dollarsChg = new BigDecimal(amtDue.intValue());
        amtDue = amtDue.subtract(dollarsChg);

        BigDecimal quartersChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(Money.QUART_IN_DOLLAR)) >= 0) {
            quartersChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(Money.QUART_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(quartersChg.multiply(BigDecimal.valueOf(Money.QUART_IN_DOLLAR)));
        }

        BigDecimal dimeChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(Money.DIME_IN_DOLLAR)) >= 0) {
            dimeChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(Money.DIME_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(dimeChg.multiply(BigDecimal.valueOf(Money.DIME_IN_DOLLAR)));
        }

        BigDecimal nickelChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(Money.NICK_IN_DOLLAR)) >= 0) {
            nickelChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(Money.NICK_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(nickelChg.multiply(BigDecimal.valueOf(Money.NICK_IN_DOLLAR)));
        }

        BigDecimal pennyChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(Money.PENN_IN_DOLLAR)) >= 0) {
            pennyChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(Money.PENN_IN_DOLLAR)).intValue());
        }
        
        Money change = new Money(dollarsChg, quartersChg, dimeChg, nickelChg, pennyChg);
        return change;
    }
}
