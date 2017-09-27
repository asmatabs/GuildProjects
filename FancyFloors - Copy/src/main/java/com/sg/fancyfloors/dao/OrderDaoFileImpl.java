/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author asmat
 */
public class OrderDaoFileImpl extends FileLoader implements OrderDao {

    Map<Integer, Order> orders = new HashMap<>();
    public static final String PRODUCT_FILE = "Orders.csv";
    public static final String DELIMITER = ",";
    public static final int NO_OF_TOKENS = 13;
    public static final int ORDER_NUMBER = 0;
    public static final int CUST_NAME = 1;
    public static final int ORDER_DATE = 2;
    public static final int STATE = 3;
    public static final int TAX_RATE = 4;
    public static final int PRODUCT_TYPE = 5;
    public static final int COST_PER_SQ_FOOT = 6;
    public static final int LABOR_COST_PER_SQ_FOOT = 7;
    public static final int AREA = 8;
    public static final int MATERIAL_COST = 9;
    public static final int LABOR_COST = 10;
    public static final int TAXAMT = 11;
    public static final int TOTAL = 12;
private int countOfOrders;

    public OrderDaoFileImpl() {
        try {
            initialize();
        } catch (FilePersistenceException ex) {
            Logger.getLogger(OrderDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initialize() throws FilePersistenceException {

        File[] ordersFiles = FilesByPattern("Orders_");

        for (File ordersFile : ordersFiles) {
            FileHandle(ordersFile.toString());
            String[] order;
            while ((order = FileReader(DELIMITER, NO_OF_TOKENS)) != null) {

                Order currentOrder = new Order(Integer.parseInt(order[ORDER_NUMBER]), LocalDate.parse(order[ORDER_DATE]) );
                currentOrder.setCustomerName(order[CUST_NAME]);

                BigDecimal taxRate = new BigDecimal(order[TAX_RATE]);
                Tax taxObj = new Tax(order[STATE], taxRate);
                currentOrder.setTax(taxObj);

                BigDecimal costPerSqFoot = new BigDecimal(order[COST_PER_SQ_FOOT]);
                BigDecimal laborCostPerSqFoot = new BigDecimal(order[LABOR_COST_PER_SQ_FOOT]);
                Product prodObj = new Product(order[PRODUCT_TYPE], costPerSqFoot, laborCostPerSqFoot);
                currentOrder.setProduct(prodObj);

                BigDecimal area = new BigDecimal(order[AREA]);
                currentOrder.setArea(area);

                BigDecimal materialCost = new BigDecimal(order[MATERIAL_COST]);
                currentOrder.setMaterialCost(materialCost);

                BigDecimal laborCost = new BigDecimal(order[LABOR_COST]);
                currentOrder.setLaborCost(laborCost);

                BigDecimal taxAmt = new BigDecimal(order[TAXAMT]);
                currentOrder.setTaxAmount(taxAmt);

                BigDecimal total = new BigDecimal(order[TOTAL]);
                currentOrder.setTotal(total);

                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }
            FileClose();
        }
    }

    @Override
    public int getNextOrderNumber() {
        return countOfOrders++;
    }
    
    @Override
    public Order getOrderByOrderNumber(int orderNum) {
        return (orders.get(orderNum) != null ? orders.get(orderNum) : null);
    }

    @Override
    public List<Order> getOrdersByCustomerName(String customerName) {
        return orders.values().stream()
                .filter((o) -> o.getCustomerName().equals(customerName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate orderDate) {
        return orders.values().stream()
                .filter((o) -> o.getOrderDate().equals(orderDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByProductType(String productType) {
        return orders.values().stream()
                .filter((Order o) -> o.getProduct().getProductType().equals(productType))
                .collect(Collectors.toList());
    }

    @Override
    public void addNewOrder(Order newOrder) {
        orders.put(newOrder.getOrderNumber(), newOrder);
    }



}
