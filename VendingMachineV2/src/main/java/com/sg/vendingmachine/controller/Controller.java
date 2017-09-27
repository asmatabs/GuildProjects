/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.FilePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.ui.View;
import java.math.BigDecimal;
import java.util.Map;
import com.sg.vendingmachine.service.VendingMachine;

/**
 *
 * @author asmat
 */
public class Controller {

    View view;
    VendingMachine service;

    public Controller(View view, VendingMachine service) {
        this.view = view;
        this.service = service;
    }

    public void start() {

        try {
            service.initializeInventory();
        } catch (FilePersistenceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        Map<String, BigDecimal> itemsWithPrices = service.getItemsWithPrices();
        view.printItems(itemsWithPrices);

        int proceed = view.confirmProceed();

        Money payment;
        boolean itemSold = false;
        if (proceed == 1) {
            payment = receivePayment();
            int option = view.getSelection(itemsWithPrices.size());
            String itemRequested = itemsWithPrices.keySet().toArray()[option - 1].toString();

            Item item = null;
            try {
                item = service.vendItem(itemRequested, payment);
                itemSold = true;
            } catch (NoItemInventoryException | InsufficientFundsException | FilePersistenceException ex) {
                view.displayErrorMessage(ex.getMessage());
            }
            if (item != null) {
                view.displayItem(item);
            }
            dispenseChange(payment, itemSold);
        }
        view.displayMessage("THANK YOU!!");
    }

    public Money receivePayment() {
        boolean paymentValid = true;
        Money money;
        do {
            money = view.getPayment();
            paymentValid = service.validatePayment(money);

        } while (!paymentValid);

        view.displayTotalAmount(money.getTotalAmount());
        return money;
    }

    void dispenseChange(Money money, boolean itemPurchased) {

        Money change;
        change = service.dispenseChange(money, itemPurchased);
        view.displayMessage("CHANGE DUE:" + change.getTotalAmount());
        view.displayChange(change);
    }

}
