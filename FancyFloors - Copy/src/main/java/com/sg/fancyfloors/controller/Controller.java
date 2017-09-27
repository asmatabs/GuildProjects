/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.controller;

import com.sg.fancyfloors.service.FlooringOrders;
import com.sg.fancyfloors.ui.View;
import com.sg.fancyfloors.model.OrderRequest;
import com.sg.fancyfloors.model.OrderResponse;
import java.time.LocalDate;

/**
 *
 * @author asmat
 */
public class Controller {

    FlooringOrders service;
    View view;

    public Controller(FlooringOrders service, View view) {
        this.service = service;
        this.view = view;
    }

    public void start() {
        boolean exit = false;
        do {

            int option = view.displayMenuAndGetSelection();

            switch (option) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again");
            }
        } while (!exit);
    }

    private void displayOrders() {
        int orderNumber = view.getOrderNumber();
        
        LocalDate date = view.getOrderDate();
        
        System.out.println("Date: " + date);
        
    }

    private void addOrder() {
        OrderRequest request = view.getNewOrder();
        OrderResponse response = service.processOrder(request);
        if (response.isOrderPlaced())
        {
            //print order
        }
        else
        {
            //print error messages
        }
    }

    private void editOrder() {
        view.getOrderNumber();
    }

    private void removeOrder() {
         view.getOrderNumber();
    }

    private void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
