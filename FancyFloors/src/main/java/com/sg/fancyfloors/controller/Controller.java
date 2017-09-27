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
        
        if(!service.initialize())
        {
            view.displayMessage("Initialization failed.");
            return;
        }
        
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
            OrderResponse response = service.searchForOrders(option, orderDate, orderNumber, customerName);
            if (response.getMessage().isEmpty()) {
                List<Order> ordersList = response.getOrder();
                if (ordersList.isEmpty()) {
                    view.displayMessage("No order found");
                } else {
                    ordersList.forEach((order) -> {
                        view.displayOrder(order);
                    });
                }
            } else {
                response.getMessage().forEach((errmsg) -> {                    
                    view.displayMessage(errmsg);
                });
                exit = true;
            }
            
        } while (!exit);
    }
    
    private void addOrder() {
        OrderRequest request = view.getNewOrder();
        OrderResponse response = service.addOrder(request);
        
        if (response.isOrderPlaced()) {
            view.displayOrder(response.getOrder().get(0));
            if (view.confirm("Do you wish to proceed? (Y/N):")) {
                service.confirmAddOrder(response.getOrder().get(0));
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
        OrderResponse response;
        
        response = service.searchForOrders(1, orderDate, orderNumber, "");
        List<Order> ordersList = response.getOrder();
        if (!response.getMessage().isEmpty()) {
            response.getMessage().forEach((errMsg) -> {
                view.displayMessage(errMsg);
            });
            return;
        }
        Order orderToEdit = null;
        if (ordersList.size() > 0) {
            orderToEdit = ordersList.get(0);
        } else {
            view.displayMessage("No order found");
        }
        OrderRequest editOrderRequest = view.editOrder(orderToEdit);
        
        response = service.editOrder(orderToEdit, editOrderRequest);
        if (!response.getMessage().isEmpty()) {
            response.getMessage().forEach((errMsg) -> {
                view.displayMessage(errMsg);
            });
        }
        if (response.isOrderPlaced()) {
            view.displayMessage("Your order was successfully edited.");
            view.displayOrder(orderToEdit);
        }
    }
    
    private void removeOrder() {
        LocalDate orderDate = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        
        OrderResponse response = service.searchForOrders(1, orderDate, orderNumber, "");
        if (!response.getMessage().isEmpty()) {
            response.getMessage().forEach((errMsg) -> {
                view.displayMessage(errMsg);
            });
            return;
        }
        List<Order> ordersList = response.getOrder();
        Order orderToRemove;
        if (ordersList.size() > 0) {
            orderToRemove = ordersList.get(0);
            view.displayOrder(orderToRemove);
            if (view.confirm("Do you wish to proceed? (Y/N):")) {
                response = service.removeOrder(orderDate, orderToRemove);
                if (!response.getMessage().isEmpty()) {
                    response.getMessage().forEach((errMsg) -> {
                        view.displayMessage(errMsg);
                    });
                } else {
                    view.displayMessage("Your order was successfully removed.");
                }
            }
        } else {
            view.displayMessage("No order found");
        }
    }
    
    private void save() {
        if (service.save(true)) {
            view.displayMessage("Transactions saved successfully.");
        } else {
            view.displayMessage("Could not save data to file.");
        }
    }
    
    private void exitApp() {
        service.save(view.confirm("Do you want to save your changes? (Y/N): "));
    }
}
