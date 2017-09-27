/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.ui;

import com.sg.fancyfloors.model.Order;
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

    public void displayWelcomeBanner() {

        io.print("");
        io.print( "ÛÛÛÛÛÛÛÛÛÛÛ                                             ÛÛÛÛÛÛÛÛÛÛÛ ÛÛÛÛ                                    \n "
               +"°°ÛÛÛ°°°°°°Û                                            °°ÛÛÛ°°°°°°Û°°ÛÛÛ                                     \n"
               +"  °ÛÛÛ   Û °   ÛÛÛÛÛÛ   ÛÛÛÛÛÛÛÛ    ÛÛÛÛÛÛ  ÛÛÛÛÛ ÛÛÛÛ    °ÛÛÛ   Û °  °ÛÛÛ   ÛÛÛÛÛÛ   ÛÛÛÛÛÛ  ÛÛÛÛÛÛÛÛ   ÛÛÛÛÛ \n"
               +"  °ÛÛÛÛÛÛÛ    °°°°°ÛÛÛ °°ÛÛÛ°°ÛÛÛ  ÛÛÛ°°ÛÛÛ°°ÛÛÛ °ÛÛÛ     °ÛÛÛÛÛÛÛ    °ÛÛÛ  ÛÛÛ°°ÛÛÛ ÛÛÛ°°ÛÛÛ°°ÛÛÛ°°ÛÛÛ ÛÛÛ°°  \n"
               +"  °ÛÛÛ°°°Û     ÛÛÛÛÛÛÛ  °ÛÛÛ °ÛÛÛ °ÛÛÛ °°°  °ÛÛÛ °ÛÛÛ     °ÛÛÛ°°°Û    °ÛÛÛ °ÛÛÛ °ÛÛÛ°ÛÛÛ °ÛÛÛ °ÛÛÛ °°° °°ÛÛÛÛÛ \n"
               +"  °ÛÛÛ  °     ÛÛÛ°°ÛÛÛ  °ÛÛÛ °ÛÛÛ °ÛÛÛ  ÛÛÛ °ÛÛÛ °ÛÛÛ     °ÛÛÛ  °     °ÛÛÛ °ÛÛÛ °ÛÛÛ°ÛÛÛ °ÛÛÛ °ÛÛÛ      °°°°ÛÛÛ\n"
               +"  ÛÛÛÛÛ      °°ÛÛÛÛÛÛÛÛ ÛÛÛÛ ÛÛÛÛÛ°°ÛÛÛÛÛÛ  °°ÛÛÛÛÛÛÛ     ÛÛÛÛÛ       ÛÛÛÛÛ°°ÛÛÛÛÛÛ °°ÛÛÛÛÛÛ  ÛÛÛÛÛ     ÛÛÛÛÛÛ \n"
               +" °°°°°        °°°°°°°° °°°° °°°°°  °°°°°°    °°°°°ÛÛÛ    °°°°°       °°°°°  °°°°°°   °°°°°°  °°°°°     °°°°°°  \n"
               +"                                            ÛÛÛ °ÛÛÛ                                                          \n"
               +"                                           °°ÛÛÛÛÛÛ                                                           \n"
               +"                                            °°°°°°                        ");
                                           
    }

    public void displayMessage(String message) {
        io.print(message);
    }

    public int displayMenuAndGetSelection() {
        io.print("");
        io.print(" 1 -> SEARCH FOR ORDER");
        io.print(" 2 -> CREATE NEW ORDER");
        io.print(" 3 -> EDIT AN ORDER");
        io.print(" 4 -> REMOVE AN ORDER");
        io.print(" 5 -> SAVE YOUR WORK");
        io.print(" 6 -> EXIT");

        return io.readInt("SELECT AN OPTION: ", 1, 6);
    }

    public int displaySubMenuAndGetSelection() {
        io.print("");
        io.print("1 -> Search By Order Number");
        io.print("2 -> Search By Customer Name");
        io.print("3 -> Display all orders for this date ");
        io.print("4 -> Exit to Main menu");

        return io.readInt("SELECT AN OPTION: ", 1, 4);
    }

    public int getOrderNumber() {
        return io.readInt("ORDER #: ", 0, 1000000);
    }

    public LocalDate getOrderDate() {
        return io.readDate("ORDER DATE (YYYY-MM-DD): ");
    }

    public String getCustomerName() {
        return io.readString("CUSTOMER NAME: ");
    }

    public OrderRequest getNewOrder() {

        String customerName = io.readString("CUSTOMER NAME: ");
        String productType = io.readString("PRODUCT TYPE [WOOD/LAMINATE/TILE/CARPET]: ");
        String state = io.readString("STATE [ABBRV.]: ");
        BigDecimal area = io.readBigDecimal("AREA [SQ FT]: ");

        return new OrderRequest(customerName, productType, state, area);
    }

    public void displayOrder(Order order) {

        io.print("===============================");
        io.print("ORDER NUMBER  : " + order.getOrderNumber());
        io.print("CUSTOMER NAME : " + order.getCustomerName());
        io.print("PRODUCT TYPE  : " + order.getProduct().getProductType());
        io.print("MATERIAL COST : " + order.getMaterialCost());
        io.print("LABOR COST    : " + order.getLaborCost());
        io.print("TAX           : " + order.getTaxAmount());
        io.print("TOTAL         : " + order.getTotal());
        io.print("===============================");
    }

    public boolean confirm(String prompt) {

        String confirm = io.readYorN(prompt);

        return confirm.compareToIgnoreCase("Y") == 0;
    }

    public OrderRequest editOrder(Order orderToEdit) {

        io.print("EDIT YOUR ORDER");
        io.print("---------------");
        String newCustomerName = io.readString("CUSTOMER NAME (" + orderToEdit.getCustomerName() + "):");
        String newProductType = io.readString("PRODUCT TYPE (" + orderToEdit.getProduct().getProductType() + "):");
        String newState = io.readString("STATE (" + orderToEdit.getTax().getState() + "):");
        BigDecimal newArea = io.readBigDecimal("AREA (" + orderToEdit.getArea() + "):");

        return new OrderRequest(newCustomerName, newProductType, newState, newArea);
    }

}
