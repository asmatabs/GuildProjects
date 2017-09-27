/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.ui;

import com.sg.fancyfloors.model.OrderRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author asmat
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetSelection() {

        io.print(" 1 -> Display order");
        io.print(" 2 -> Add an order");
        io.print(" 3 -> Edit an order");
        io.print(" 4 -> Remove an order");
        io.print(" 5 -> Save your work");
        io.print(" 6 -> Exit");

        return io.readInt("SELECT AN OPTION: ", 1, 6);
    }

    public int getOrderNumber() {
        return io.readInt("Order Number: ", 0, 1000000);
    }

    public LocalDate getOrderDate() {
        return io.readDate("Order Date (YYYY-MM-DD): ");
    }

    public OrderRequest getNewOrder() {

        String customerName = io.readString("Customer Name: ");
        String productType = io.readString("Product Type (Wood/Laminate/Tile/Carpet): ");
        String state = io.readString("State: ");
        BigDecimal area = io.readBigDecimal("Area: ");

        return new OrderRequest(customerName, productType, state, area);
    }

}
