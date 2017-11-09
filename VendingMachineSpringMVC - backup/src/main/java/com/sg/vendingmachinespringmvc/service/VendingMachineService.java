/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.model.Money;
import com.sg.vendingmachinespringmvc.model.Response;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class VendingMachineService {

    VendingMachineDao dao;
    private BigDecimal amountInMachine = new BigDecimal(0.0);
    public final double QUART_IN_DOLLAR = 0.25;
    public final double DIME_IN_DOLLAR = 0.10;
    public final double NICK_IN_DOLLAR = 0.05;
    public final double PENN_IN_DOLLAR = 0.01;

    public VendingMachineService(VendingMachineDao dao) {
        this.dao = dao;
    }

    public Item getItem(int itemId) {
        return dao.getItem(itemId);
    }

    public Map<Integer, Item> getItems() {
        return dao.getItems();
    }

    public Response vendItem(int id, BigDecimal amountInMachine) {

        Response response = new Response();
        Item currentItem = dao.getItem(id);
        BigDecimal changeDue = amountInMachine;
        
        boolean itemDispensed = true;
        if (currentItem.getQuantity() <= 0) {
            response.setMessage("Sold Out!!");
            itemDispensed = false;
        } 
        else {
            if (currentItem.getPrice().compareTo(amountInMachine) == 1) {
                BigDecimal diffAmount = currentItem.getPrice().subtract(amountInMachine);
                response.setMessage("Please deposit " + diffAmount.toString());
                itemDispensed = false;
            }
        }
        
        if (itemDispensed) {
            dao.removeItem(id);
            changeDue = amountInMachine.subtract(currentItem.getPrice());
        }
        String change = calculateChange(changeDue);
        
        response.setChange(change);
        response.setItemDispensed(itemDispensed);
        return response;
    }

    public String calculateChange(BigDecimal changeDue) {

        String change = "";
        BigDecimal quartersChg = BigDecimal.ZERO;
        if (changeDue.compareTo(BigDecimal.valueOf(QUART_IN_DOLLAR)) >= 0) {
            quartersChg = new BigDecimal(changeDue.divideToIntegralValue(BigDecimal.valueOf(QUART_IN_DOLLAR)).intValue());
            changeDue = changeDue.subtract(quartersChg.multiply(BigDecimal.valueOf(QUART_IN_DOLLAR)));
            change += quartersChg.toString() + " Quarter ";
        }

        BigDecimal dimeChg = BigDecimal.ZERO; 
        if (changeDue.compareTo(BigDecimal.valueOf(DIME_IN_DOLLAR)) >= 0) {
            dimeChg = new BigDecimal(changeDue.divideToIntegralValue(BigDecimal.valueOf(DIME_IN_DOLLAR)).intValue());
            changeDue = changeDue.subtract(dimeChg.multiply(BigDecimal.valueOf(DIME_IN_DOLLAR)));
            change += dimeChg.toString() + " Dime ";
        }

        BigDecimal nickelChg = BigDecimal.ZERO;
        if (changeDue.compareTo(BigDecimal.valueOf(NICK_IN_DOLLAR)) >= 0) {
            nickelChg = new BigDecimal(changeDue.divideToIntegralValue(BigDecimal.valueOf(NICK_IN_DOLLAR)).intValue());
            changeDue = changeDue.subtract(nickelChg.multiply(BigDecimal.valueOf(NICK_IN_DOLLAR)));
            change += nickelChg.toString() + " Nickel ";
        }

        BigDecimal pennyChg = BigDecimal.ZERO;
        if (changeDue.compareTo(BigDecimal.valueOf(PENN_IN_DOLLAR)) >= 0) {
            pennyChg = new BigDecimal(changeDue.divideToIntegralValue(BigDecimal.valueOf(PENN_IN_DOLLAR)).intValue());
            change += pennyChg.toString() + " Penny ";
        }
        return change;
    }

    public BigDecimal addDollar(BigDecimal amount) {
        return amount.add(BigDecimal.ONE);
    }

    public BigDecimal addQuarter(BigDecimal amount) {
        return amount.add(BigDecimal.valueOf(0.25));
    }

    public BigDecimal addDime(BigDecimal amount) {
        return amount.add(BigDecimal.valueOf(0.10));
    }

    public BigDecimal addNickel(BigDecimal amount) {
        return amount.add(BigDecimal.valueOf(0.05));
    }
}
