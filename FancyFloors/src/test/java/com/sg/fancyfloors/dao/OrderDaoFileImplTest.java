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
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author asmat 
 */
public class OrderDaoFileImplTest {

    OrderDao orderDao = new OrderDaoFileImpl();

    public OrderDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOrderByOrderNumber method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetOrderByDateAndOrderNumberSuccess() {
        Order testOrder = new Order(1,LocalDate.parse("2017-01-13") );
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

        try {
            assertEquals(testOrder, orderDao.getOrderByDateAndOrderNumber(LocalDate.parse("2017-01-13"),1).get(0));
        } catch (FilePersistenceException ex) {
             fail("Get order by order number failed");
        }
    }

    @Test
    public void testGetOrderByDateAndOrderNumberFailure() {
        try {
            assertEquals(0, orderDao.getOrderByDateAndOrderNumber(LocalDate.parse("2017-01-13"),1002).size());
        } catch (FilePersistenceException ex) {
            fail("Get order by order number failed");
        }
    }

    /**
     * Test of getOrdersByCustomerName method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetOrdersByDateAndCustomerNameSuccess() {
        try {
            assertEquals(1,orderDao.getOrdersByDateAndCustomerName(LocalDate.parse("2017-01-13"),"Wise").size());
        } catch (FilePersistenceException ex) {
            fail("Get order by Customer Name failed");
        }
    }

    @Test
    public void testGetOrdersByCustomerNameFailure() {
        try {
            assertEquals(0, orderDao.getOrdersByDateAndCustomerName(LocalDate.parse("2017-01-13"),"Jerry").size());
        } catch (FilePersistenceException ex) {
            fail("Get order by Customer Name failed");
        }
    }

    /**
     * Test of getOrdersByDate method, of class OrderDaoFileImpl.
     */
    @Test
    public void testGetOrdersByDateSuccess() {
        try {
            assertEquals(1,orderDao.getOrdersByDate(LocalDate.parse("2017-01-13")).size());
        } catch (FilePersistenceException ex) {
            fail("Get orders by Date failed");
        }
    }
}
