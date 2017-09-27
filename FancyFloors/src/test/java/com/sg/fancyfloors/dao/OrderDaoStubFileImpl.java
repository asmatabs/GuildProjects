/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author asmat
 */
public class OrderDaoStubFileImpl implements OrderDao {

    Map<String, List<Order>> orders = new HashMap<>();

    @Override
    public void initialize() throws FilePersistenceException {
        String testFile = "Orders_2017925.txt";
        Order testOrder = new Order(1, LocalDate.parse("2017-09-25"));
        testOrder.setCustomerName("Wise");

        BigDecimal taxRate = new BigDecimal("6.25");
        Tax taxObj = new Tax("OH", taxRate);
        testOrder.setTax(taxObj);

        BigDecimal costPerSqFoot = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFoot = new BigDecimal("4.75");
        Product prodObj = new Product("Wood", costPerSqFoot, laborCostPerSqFoot);
        testOrder.setProduct(prodObj);

        BigDecimal area = new BigDecimal("100.00");
        testOrder.setArea(area);

        BigDecimal materialCost = new BigDecimal("515.00");
        testOrder.setMaterialCost(materialCost);

        BigDecimal laborCost = new BigDecimal("475.00");
        testOrder.setLaborCost(laborCost);

        BigDecimal taxAmt = new BigDecimal("61.88");
        testOrder.setTaxAmount(taxAmt);

        BigDecimal total = new BigDecimal("1051.88");
        testOrder.setTotal(total);

        List<Order> orderList = new ArrayList<>();
        orderList.add(testOrder);
        orders.put(testFile, orderList);
    }

    @Override
    public int getNextOrderNumber() {
        return 0;
    }

    @Override
    public List<Order> getOrderByDateAndOrderNumber(LocalDate date, int orderNum) throws FilePersistenceException {

        String fileName = "Orders_2017925.txt";
        return orders.get(fileName)
                .stream()
                .filter((o) -> o.getOrderNumber() == orderNum)
                .collect(Collectors.toList());

    }

    @Override
    public List<Order> getOrdersByDateAndCustomerName(LocalDate date, String customerName) throws FilePersistenceException {
        return null;
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate orderDate) throws FilePersistenceException {
        return null;
    }

    @Override
    public void addNewOrder(Order newOrder) {
        List<Order> list = orders.get("Orders_2017925.txt");
        list.add(newOrder);

        orders.put("Orders_2017925.txt", list);
    }

    @Override
    public void removeOrder(LocalDate orderDate, Order orderToRemove) throws FilePersistenceException {

        List<Order> ordersList = orders.get("Orders_2017925.txt");
        ordersList.remove(orderToRemove);
    }

    @Override
    public void save() throws FilePersistenceException {
    }

}
