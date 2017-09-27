/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.controller;

import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.service.FlooringOrders;
import com.sg.fancyfloors.ui.View;
import com.sg.fancyfloors.model.OrderRequest;
import com.sg.fancyfloors.model.OrderResponse;
import java.time.LocalDate;
import java.util.List;

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
        view.displayWelcomeBanner();
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
                    exitApp();
                    return;
                default:
                    view.displayMessage("Invalid selection. Please try again!");
            }
        } while (!exit);
    }
    
    private void displayOrders() {
        
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = 0;
        String customerName = "";
        boolean exit = false;
        do {
            int option = view.displaySubMenuAndGetSelection();
            
            switch (option) {
                case 1:
                    orderNumber = view.getOrderNumber();
                    break;
                case 2:
                    customerName = view.getCustomerName();
                    break;
                case 4:
                    return;
            }
            List<Order> ordersList = service.searchForOrders(option, orderDate, orderNumber, customerName);
            if (ordersList.isEmpty()) {
                view.displayMessage("No order found");
            } else {
                ordersList.forEach((order) -> {
                    view.displayOrder(order);
                });
            }
        } while (!exit);
    }
    
    private void addOrder() {
        OrderRequest request = view.getNewOrder();
        OrderResponse response = service.addOrder(request);
        
        if (response.isOrderPlaced()) {
            view.displayOrder(response.getOrder());
            if (view.confirm("Do you wish to proceed? (Y/N):")) {
                service.confirmAddOrder(response.getOrder());
            }
        } else {
            response.getMessage().forEach((errMsg) -> {
                view.displayMessage(errMsg);
            });
        }
    }
    
    private void editOrder() {
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        
        List<Order> ordersList = service.searchForOrders(1, orderDate, orderNumber, "");
        Order orderToEdit = null;
        if (ordersList.size() > 0) {
            orderToEdit = ordersList.get(0);
        } else {
            view.displayMessage("No order found");
        }
        OrderRequest editOrderRequest = view.editOrder(orderToEdit);
        
        OrderResponse response = service.editOrder(orderToEdit, editOrderRequest);
        
        if (response.isOrderPlaced()) {
            view.displayMessage("Your order was successfully edited.");
            view.displayOrder(orderToEdit);
        } else {
            response.getMessage().forEach((errMsg) -> {
                view.displayMessage(errMsg);
            });
        }
    }
    
    private void removeOrder() {
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        
        List<Order> ordersList = service.searchForOrders(1, orderDate, orderNumber, "");
        Order orderToRemove = null;
        if (ordersList.size() > 0) {
            orderToRemove = ordersList.get(0);
            view.displayOrder(orderToRemove);
            if (view.confirm("Do you wish to proceed? (Y/N):")) {
                OrderResponse response = service.removeOrder(orderDate, orderToRemove);
                if (response.getMessage().isEmpty()) {
                    view.displayMessage("Your order was successfully removed.");
                }
                
            }
        } else {
            view.displayMessage("No order found");
        }
    }
    
    private void save() {
        service.save(true);
    }
    
    private void exitApp() {
        service.save(view.confirm("Do you want to save your changes? (Y/N): "));
    }
}
