/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    public final double QUART_IN_DOLLAR = 0.25;
    public final double DIME_IN_DOLLAR = 0.10;
    public final double NICK_IN_DOLLAR = 0.05;
    public final double PENN_IN_DOLLAR = 0.01;

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Item getItemFromInventory(int option, Money money)
            throws VMNoItemInventoryException, VMInsufficientFundsException, VMPersistenceException {
        ItemPrice itemPrice = dao.getItemPrice(option - 1);

        if (itemPrice.getPrice().compareTo(money.getTotalAmount()) == 1) {
            throw new VMInsufficientFundsException("Cash available is not enough for this item");
        }
        Item item = dao.getItem(itemPrice.getName());
        if (item == null) {
            throw new VMNoItemInventoryException("Sold out on this item");
        }

        dao.removeItem(item);

        try {
            dao.updateInventory();
        } catch (VMPersistenceException ex) {
            throw new VMPersistenceException(ex.getMessage());
        }
        BigDecimal changeDue = money.getTotalAmount().subtract(itemPrice.getPrice());
        money.setChangeDue(changeDue);
        return item;
    }

    @Override
    public void initializeInventory() throws VMPersistenceException {
        dao.loadInventory();
        dao.loadPricingInfo();
    }

    @Override
    public Map<String, BigDecimal> getItemsWithPrices() {
        return dao.getItemsWithPrices();
    }

    @Override
    public boolean validatePayment(Money money) {

        BigDecimal totalAmount = money.getDollar()
                .add((money.getQuarter().multiply(BigDecimal.valueOf(QUART_IN_DOLLAR)))
                        .add((money.getDime().multiply(BigDecimal.valueOf(DIME_IN_DOLLAR)))
                                .add((money.getNickel().multiply(BigDecimal.valueOf(NICK_IN_DOLLAR)))
                                        .add((money.getPenny().multiply(BigDecimal.valueOf(PENN_IN_DOLLAR)))))));

        if (totalAmount.intValue() <= 0) {
            return false;
        }
        money.setTotalAmount(totalAmount);
        return true;
    }

    @Override
    public Money calculateChange(Money money) {
        BigDecimal amtDue = money.getChangeDue();

        BigDecimal dollarsChg = new BigDecimal(amtDue.intValue());
        amtDue = amtDue.subtract(dollarsChg); 

        BigDecimal quartersChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(QUART_IN_DOLLAR)) >= 0) {
            quartersChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(QUART_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(quartersChg.multiply(BigDecimal.valueOf(QUART_IN_DOLLAR)));
        }
        
        BigDecimal dimeChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(DIME_IN_DOLLAR)) >= 0) {
            dimeChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(DIME_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(dimeChg.multiply(BigDecimal.valueOf(DIME_IN_DOLLAR)));
        }
        
        BigDecimal nickelChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(NICK_IN_DOLLAR)) >= 0) {
            nickelChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(NICK_IN_DOLLAR)).intValue());
            amtDue = amtDue.subtract(nickelChg.multiply(BigDecimal.valueOf(NICK_IN_DOLLAR)));
        }
        
        BigDecimal pennyChg = BigDecimal.ZERO;
        if (amtDue.compareTo(BigDecimal.valueOf(PENN_IN_DOLLAR)) >= 0) {
            pennyChg = new BigDecimal(amtDue.divideToIntegralValue(BigDecimal.valueOf(PENN_IN_DOLLAR)).intValue());
        }
        return new Money(dollarsChg,quartersChg, dimeChg, nickelChg, pennyChg);
    }
}
