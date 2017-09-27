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

/**
 *
 * @author asmat
 */
public class FlooringOrders {

    OrderDao orderDao;
    ProductDao productDao;
    TaxDao taxDao;
    public final int ADD_MODE = 1;
    public final int EDIT_MODE = 2;

    public FlooringOrders(OrderDao orderDao, ProductDao productDao, TaxDao taxDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
    }

    public boolean initialize() {
        boolean response = true;

        try {
            productDao.initialize();
            taxDao.initialize();
            orderDao.initialize();
        } catch (FilePersistenceException ex) {
            response = false;
        }
        return response;
    }

    public OrderResponse addOrder(OrderRequest request) {

        return processOrder(ADD_MODE, request, null);
    }

    public void confirmAddOrder(Order order) {
     
        orderDao.addNewOrder(order);
    }

    public OrderResponse editOrder(Order orderToEdit, OrderRequest editOrderRequest) {

        return processOrder(EDIT_MODE, editOrderRequest, orderToEdit);
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

    public OrderResponse searchForOrders(int option, LocalDate orderDate, int orderNumber, String customerName) {

        List<Order> orderList = null;
        OrderResponse response = new OrderResponse();
        if (orderDate.isAfter(LocalDate.now())) {
            response.setMessage("Order Date cannot be in future");
            return response;
        }
        switch (option) {
            case 1: {
                try {
                    orderList = orderDao.getOrderByDateAndOrderNumber(orderDate, orderNumber);
                } catch (FilePersistenceException ex) {
                    response.setMessage("Could not load orders for date " + orderDate);
                }
            }
            break;
            case 2: {
                try {
                    orderList = orderDao.getOrdersByDateAndCustomerName(orderDate, customerName);
                } catch (FilePersistenceException ex) {
                    response.setMessage("Could not load orders for date " + orderDate);
                }
            }
            break;
            case 3: {
                try {
                    orderList = orderDao.getOrdersByDate(orderDate);
                } catch (FilePersistenceException ex) {
                    response.setMessage("Could not load orders for date " + orderDate);
                }
            }
            break;
            default:
                response.setMessage("Invalid option");
        }
        response.setOrder(orderList);
        return response;
    }

    private OrderResponse processOrder(int mode, OrderRequest orderRequest, Order orderToEdit) {

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderPlaced(false);
        boolean validRequest = true;

        //Validate ProductType
        Product currentProduct = null;
        if (mode == ADD_MODE || (mode == EDIT_MODE && orderRequest.getProductType().compareTo("") != 0)) {
            currentProduct = productDao.getProductByType(orderRequest.getProductType());
            if (currentProduct == null) {
                orderResponse.setMessage("There is no such Product. Please check the Product Type");
                validRequest = false;
            }
        }

        //Validate State
        Tax currentTax = null;
        if (mode == ADD_MODE || (mode == EDIT_MODE && orderRequest.getState().compareTo("") != 0)) {
            currentTax = taxDao.getTaxByState(orderRequest.getState());
            if (currentTax == null) {
                orderResponse.setMessage("Incorrect state.");
                validRequest = false;
            }
        }

        if (mode == ADD_MODE && orderRequest.getArea().intValue() <= 0) {
            orderResponse.setMessage("We need some Area to work with.");
            validRequest = false;
        }

        List<Order> orderList = new ArrayList<>();
        if (validRequest) {
            if (mode == ADD_MODE) {
                //Create new Order
                Order newOrder = new Order(orderDao.getNextOrderNumber(), LocalDate.now());
                newOrder.setCustomerName(orderRequest.getCustomerName());
                newOrder.setArea(orderRequest.getArea());
                newOrder.setProduct(currentProduct);
                newOrder.setTax(currentTax);

                updateCostForOrder(newOrder);
                orderList.add(newOrder);
                orderResponse.setOrder(orderList);
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
                orderList.add(orderToEdit);
                orderResponse.setOrder(orderList);
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

    public boolean save(boolean saveWork) {

        boolean response = true;
        try {
            if (saveWork) {
                orderDao.save();
            }
        } catch (FilePersistenceException ex) {
            response = false;
        }
        return response;
    }
}
