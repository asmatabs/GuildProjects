/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VMPersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import com.sg.vendingmachine.service.VMInsufficientFundsException;
import com.sg.vendingmachine.service.VMNoItemInventoryException;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.service.VendingMachineService;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineService service;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void start() {

        try {
            service.initializeInventory();
        } catch (VMPersistenceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        Map<String, BigDecimal> itemsWithPrices = service.getItemsWithPrices();
        view.printItems(itemsWithPrices);
        int proceed = view.confirmProceed();

        if (proceed == 1) {
            boolean paymentValid = true;
            Money money;
            do {
                money = view.getPayment();
                paymentValid = service.validatePayment(money);

            } while (!paymentValid);

            view.displayTotalAmount(money.getTotalAmount());

            int option = view.getSelection(itemsWithPrices.size());

            Item item = null;
            try {
                item = service.getItemFromInventory(option, money);
            } catch (VMNoItemInventoryException | VMInsufficientFundsException | VMPersistenceException ex) {
                view.displayErrorMessage(ex.getMessage());
                view.displayChange(money);
                return;
            } 
            view.displayItem(item);
            dispenseChange(money);

        }
        view.displayMessage("GOOD BYE");
    }

    void dispenseChange(Money money) {
        Money change = service.calculateChange(money);
        view.displayMessage("CHANGE DUE:" + money.getChangeDue());
        view.displayChange(change);
    }
}
