/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author asmat
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int confirmProceed() {
        int option = io.readInt("Press 0 to exit, 1 to continue:", 0, 1);
        return option;
    }

    public int getSelection(int limit) {
        return io.readInt("SELECT AN ITEM: ", 1, limit);
    }

    public void printItems(Map<String, BigDecimal> items) {

        int i = 1;
        for (Map.Entry<String, BigDecimal> entry : items.entrySet()) {
            System.out.printf("%d - %-20s --> $%s\n", i++, entry.getKey(), entry.getValue().toString());
        }

    }

    public Money getPayment() {

        io.print("INSERT CASH TO BEGIN");
        BigDecimal dollars = io.readBigDecimal("Dollars:");
        BigDecimal quarter = io.readBigDecimal("Quarter:");
        BigDecimal dime = io.readBigDecimal("Dime:");
        BigDecimal nickel = io.readBigDecimal("Nickel:");
        BigDecimal penny = io.readBigDecimal("Penny:");

        return new Money(dollars, quarter, dime, nickel, penny);
    }

    public void displayTotalAmount(BigDecimal total) {
        io.print("CASH ENTERED: " + total);
    }

    public void displayErrorMessage(String msg) {
        io.print(msg);
    }

    public void displayMessage(String msg) {
        io.print(msg);
    }

    public void displayItem(Item item) {
        io.print("");

        io.print("/ \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n"
                +"/ \\                                                             / \\ \n"
                +"\\ /                   ITEM DISPENSED                            \\ /\n"
                +"\\ /                                                             \\ /\n"
                +"\\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ /");
        
        io.print("");
        io.print("----------------------------------------");
        io.print(item.getName());
        io.print("Maunfacture Date: " + item.getManufacturerDate());
        io.print("Nutrition Label: " + item.getNutriInfo());
        io.print("----------------------------------------");
    }

    public void displayChange(Money money) {
        io.print("");
        io.print("PLEASE TAKE YOUR");
        io.print(" _ __ ___   ___  _ __   ___ _   _\n"
                + "| '_ ` _ \\ / _ \\| '_ \\ / _ \\ | | |\n"
                + "| | | | | | (_) | | | |  __/ |_| |\n"
                + "|_| |_| |_|\\___/|_| |_|\\___|\\__, |\n"
                + "                             __/ |\n"
                + "                            |___/\n");

        io.print("Dollars:  " + money.getDollar());
        io.print("Quarter:  " + money.getQuarter());
        io.print("Dime   :  " + money.getDime());
        io.print("Nickel :  " + money.getNickel());
        io.print("Penny  :  " + money.getPenny());
    }

}
