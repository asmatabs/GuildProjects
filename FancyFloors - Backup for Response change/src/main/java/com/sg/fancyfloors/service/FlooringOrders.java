/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.service;

import com.sg.fancyfloors.dao.FilePersistenceException;
import com.sg.fancyfloors.dao.OrderDao;
import com.sg.fancyfloors.dao.ProductDao;
import com.sg.fancyfloors.dao.TaxDao;
import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.model.OrderRequest;
import com.sg.fancyfloors.model.OrderResponse;
import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asmat
 */
public class FlooringOrders {

    OrderDao orderDao;
    ProductDao productDao;
    TaxDao taxDao;

    public FlooringOrders(OrderDao orderDao, ProductDao productDao, TaxDao taxDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
    }

    public OrderResponse processOrder(int mode, OrderRequest orderRequest, Order orderToEdit) {

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderPlaced(false);
        boolean validRequest = true;

        //Validate ProductType
        Product currentProduct = null;
        if (mode == 1 || (mode == 2 && orderRequest.getProductType().compareTo("") != 0)) {
            currentProduct = productDao.getProductByType(orderRequest.getProductType());
            if (currentProduct == null) {
                orderResponse.setMessage("There is no such Product. Please check the Product Type");
                validRequest = false;
            }
        }

        //Validate State
        Tax currentTax = null;
        if (mode == 1 || (mode == 2 && orderRequest.getState().compareTo("") != 0)) {
            currentTax = taxDao.getTaxByState(orderRequest.getState());
            if (currentTax == null) {
                orderResponse.setMessage("Incorrect state.");
                validRequest = false;
            }
        }

        if (mode == 1 && orderRequest.getArea().intValue() <= 0) {
            orderResponse.setMessage("We need some Area to work with.");
            validRequest = false;
        }

        if (validRequest) {
            if (mode == 1) {
                //Create new Order
                Order newOrder = new Order(orderDao.getNextOrderNumber(), LocalDate.now());
                newOrder.setCustomerName(orderRequest.getCustomerName());
                newOrder.setArea(orderRequest.getArea());
                newOrder.setProduct(currentProduct);
                newOrder.setTax(currentTax);

                updateCostForOrder(newOrder);
                orderResponse.setOrder(newOrder);
            } else {
                //Update existing Order
                if (orderRequest.getCustomerName().compareTo("") != 0) {
                    orderToEdit.setCustomerName(orderRequest.getCustomerName());
                }
                if (orderRequest.getArea().compareTo(BigDecimal.ZERO) > 0) {
                    orderToEdit.setArea(orderRequest.getArea());
                }
                if (currentProduct != null) {
                    orderToEdit.setProduct(currentProduct);
                }
                if (currentTax != null) {
                    orderToEdit.setTax(currentTax);
                }
                updateCostForOrder(orderToEdit);
                orderResponse.setOrder(orderToEdit);
            }
            orderResponse.setOrderPlaced(true);
        }
        return orderResponse;
    }

    private void updateCostForOrder(Order order) {

        //Calculate Material Cost
        BigDecimal materialCost = order.getArea().multiply(order.getProduct().getCostPerSquareFoot()).setScale(2, RoundingMode.HALF_UP);
        order.setMaterialCost(materialCost);

        //Calculate Labor Cost
        BigDecimal laborCost = order.getArea().multiply(order.getProduct().getLaborCostPerSquareFoot()).setScale(2, RoundingMode.HALF_UP);
        order.setLaborCost(laborCost);

        BigDecimal totalCost = materialCost.add(laborCost);

        BigDecimal tax = (totalCost.multiply(order.getTax().getTaxRate())).divide(BigDecimal.valueOf(100.00)).setScale(2, RoundingMode.HALF_UP);
        order.setTaxAmount(tax);

        BigDecimal total = totalCost.add(tax).setScale(2, RoundingMode.HALF_UP);
        order.setTotal(total);
    }

    public List<Order> searchForOrders(int option, LocalDate orderDate, int orderNumber, String customerName) {

        List<Order> orderList = new ArrayList<>();
        switch (option) {
            case 1: {
                try {
                    orderList = orderDao.getOrderByDateAndOrderNumber(orderDate, orderNumber);
                } catch (FilePersistenceException ex) {
                    Logger.getLogger(FlooringOrders.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: {
                try {
                    orderList = orderDao.getOrdersByDateAndCustomerName(orderDate, customerName);
                } catch (FilePersistenceException ex) {
                    Logger.getLogger(FlooringOrders.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 3: {
                try {
                    orderList = orderDao.getOrdersByDate(orderDate);
                } catch (FilePersistenceException ex) {
                    Logger.getLogger(FlooringOrders.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
        return orderList;
    }

    public void confirmAddOrder(Order order) {
        orderDao.addNewOrder(order);
    }

    public OrderResponse addOrder(OrderRequest request) {

        return processOrder(1, request, null);
    }

    public OrderResponse editOrder(Order orderToEdit, OrderRequest editOrderRequest) {

        return processOrder(2, editOrderRequest, orderToEdit);
    }

    public OrderResponse removeOrder(LocalDate orderDate, Order orderToRemove) {

        OrderResponse removeResponse = new OrderResponse();
        try {
            orderDao.removeOrder(orderDate, orderToRemove);
        } catch (FilePersistenceException ex) {
            removeResponse.setMessage("Could not remove order from the system");
        }

        return removeResponse;
    }

    public boolean save(boolean saveWork) {
        
        boolean response = true;
        try {
            if (saveWork) {
                orderDao.save();
            }
        } catch (FilePersistenceException ex) {
            Logger.getLogger(FlooringOrders.class.getName()).log(Level.SEVERE, null, ex);
            response = false;
        }
        return response;
    }

}
