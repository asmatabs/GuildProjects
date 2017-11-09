/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringspringmvc.dao;

import com.sg.flooringspringmvc.model.Order;
import com.sg.flooringspringmvc.model.Product;
import com.sg.flooringspringmvc.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 *
 * @author asmat
 */
public class OrderDaoFileImpl extends FileLoader implements OrderDao {

    Map<String, List<Order>> orders = new HashMap<>();
    public static final String DELIMITER = ",";
    public static final String EOF = "\n";
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
    private int nextOrderNumber = 1;
    private String currentFile;

    public OrderDaoFileImpl() {

    }

    @Override
    public void initialize() throws FilePersistenceException {

        currentFile = getFileForDate(LocalDate.now());
        if (checkFileExists(currentFile)) {
            loadOrdersFromFile(currentFile);
        }
    }

    @Override
    public int getNextOrderNumber() {

        return nextOrderNumber++;
    }

    private void checkAndLoadFile(String fileName) throws FilePersistenceException {

        Set<String> filesInMemory = orders.keySet();
        if (!filesInMemory.contains(fileName)) {
            loadOrdersFromFile(fileName);
        }
    }

    private void loadOrdersFromFile(String fileName) throws FilePersistenceException {

        FileReaderHandle(fileName);
        List<Order> ordersForDay = new ArrayList<>();
        String[] order;
        int orderNumber = 0;
        while ((order = FileReader(DELIMITER, NO_OF_TOKENS)) != null) {

            orderNumber = Integer.parseInt(order[ORDER_NUMBER]);
            Order currentOrder = new Order(orderNumber, LocalDate.parse(order[ORDER_DATE]));

            String customerName = order[CUST_NAME];
            customerName = prepare(customerName);
            currentOrder.setCustomerName(customerName);

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

            ordersForDay.add(currentOrder);
        }
        nextOrderNumber = orderNumber + 1;
        orders.put(fileName, ordersForDay);
        FileReaderClose();
    }

    @Override
    public List<Order> getOrderByDateAndOrderNumber(LocalDate date, int orderNum)
            throws FilePersistenceException {

        String fileName = getFileForDate(date);
        checkAndLoadFile(fileName);

        return orders.get(fileName)
                .stream()
                .filter((o) -> o.getOrderNumber() == orderNum)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByDateAndCustomerName(LocalDate date, String customerName)
            throws FilePersistenceException {
        String fileName = getFileForDate(date);
        checkAndLoadFile(fileName);

        return orders.get(fileName)
                .stream()
                .filter((o) -> (o.getCustomerName().contains(customerName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date)
            throws FilePersistenceException {
        String fileName = getFileForDate(date);
        checkAndLoadFile(fileName);

        return orders.get(fileName);
    }

    @Override
    public void addNewOrder(Order newOrder) {

        Set<String> files = orders.keySet();
        List<Order> newOrders = null;
        if (files.contains(currentFile)) {
            newOrders = orders.get(currentFile);
        } else {
            newOrders = new ArrayList<>();
        }
        newOrders.add(newOrder);
        orders.put(currentFile, newOrders);
    }

    @Override
    public void removeOrder(LocalDate date, Order orderToRemove)
            throws FilePersistenceException {

        String fileName = getFileForDate(date);
        checkAndLoadFile(fileName);

        List<Order> ordersList = orders.get(fileName);
        ordersList.remove(orderToRemove);
    }

    private String getFileForDate(LocalDate date) {
        return "Orders_" + date.getYear() + date.getMonthValue() + date.getDayOfMonth() + ".txt";
    }

    @Override
    public void save()
            throws FilePersistenceException {
        Set<String> files = orders.keySet();
        for (String file : files) {
            FileWriterHandle(file);
            List<Order> ordersList = orders.get(file);

            ordersList.forEach((order) -> {
                if (order.getCustomerName().contains(",")) {
                    String customerName = '\"' + order.getCustomerName() + '\"';
                    order.setCustomerName(customerName);
                }
                String currentOrder = order.getOrderNumber() + DELIMITER
                        + order.getCustomerName() + DELIMITER
                        + order.getOrderDate() + DELIMITER
                        + order.getTax().getState() + DELIMITER
                        + order.getTax().getTaxRate() + DELIMITER
                        + order.getProduct().getProductType() + DELIMITER
                        + order.getProduct().getCostPerSquareFoot() + DELIMITER
                        + order.getProduct().getLaborCostPerSquareFoot() + DELIMITER
                        + order.getArea() + DELIMITER
                        + order.getMaterialCost() + DELIMITER
                        + order.getLaborCost() + DELIMITER
                        + order.getTaxAmount() + DELIMITER
                        + order.getTotal() + EOF;

                FileWriter(currentOrder);
            });
            FileWriterClose();
        }
    }

    private String prepare(String customerName) {
        if (customerName.startsWith("\"") && customerName.endsWith("\"")) {
            customerName = customerName.substring(1, customerName.length() - 1);
        }
        return customerName;
    }

}
