/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.service;

import com.sg.fancyfloors.dao.FilePersistenceException;
import com.sg.fancyfloors.dao.OrderDao;
import com.sg.fancyfloors.dao.OrderDaoStubFileImpl;
import com.sg.fancyfloors.dao.ProductDao;
import com.sg.fancyfloors.dao.ProductDaoFileImpl;
import com.sg.fancyfloors.dao.TaxDao;
import com.sg.fancyfloors.dao.TaxDaoFileImpl;
import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.model.OrderRequest;
import com.sg.fancyfloors.model.OrderResponse;
import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author asmat
 */
public class FlooringOrdersTest {

    OrderDao dao = new OrderDaoStubFileImpl();
    ProductDao productDao = new ProductDaoFileImpl();
    TaxDao taxDao = new TaxDaoFileImpl();

    FlooringOrders service = new FlooringOrders(dao, productDao, taxDao);

    public FlooringOrdersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            dao.initialize();
        } catch (FilePersistenceException ex) {
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class FlooringOrders.
     */
    @Test
    public void testInitialize() {
    }

    private Order createdOrder() {
        Order testOrder = new Order(10, LocalDate.parse("2017-09-25"));
        testOrder.setCustomerName("Sam");

        BigDecimal taxRate = new BigDecimal("6.25");
        Tax taxObj = new Tax("OH", taxRate);
        testOrder.setTax(taxObj);

        BigDecimal costPerSqFoot = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFoot = new BigDecimal("4.75");
        Product prodObj = new Product("Wood", costPerSqFoot, laborCostPerSqFoot);
        testOrder.setProduct(prodObj);

        BigDecimal area = new BigDecimal("100.0");
        testOrder.setArea(area);

        BigDecimal materialCost = new BigDecimal("515.00");
        testOrder.setMaterialCost(materialCost);

        BigDecimal laborCost = new BigDecimal("475.00");
        testOrder.setLaborCost(laborCost);

        BigDecimal taxAmt = new BigDecimal("61.88");
        testOrder.setTaxAmount(taxAmt);

        BigDecimal total = new BigDecimal("1051.88");
        testOrder.setTotal(total);

        return testOrder;
    }

    /**
     * Test of addOrder method, of class FlooringOrders.
     */
    @Test
    public void testAddOrder() {

        Order testOrder = createdOrder();
        OrderRequest addOrder = new OrderRequest("Sam", "Wood", "OH", BigDecimal.valueOf(100.00));
        OrderResponse response = service.addOrder(addOrder);

        assertEquals(testOrder, response.getOrder().get(0));

    }

    /**
     * Test of confirmAddOrder method, of class FlooringOrders.
     */
    @Test
    public void testConfirmAddOrder() {
    }

    /**
     * Test of editOrder method, of class FlooringOrders.
     */
    @Test
    public void testEditOrder() {
        Order testOrder = new Order(2, LocalDate.parse("2017-09-25"));
        testOrder.setCustomerName("Sam");

        BigDecimal taxRate = new BigDecimal("6.25");
        Tax taxObj = new Tax("OH", taxRate);
        testOrder.setTax(taxObj);

        BigDecimal costPerSqFoot = new BigDecimal("5.15");
        BigDecimal laborCostPerSqFoot = new BigDecimal("4.75");
        Product prodObj = new Product("Wood", costPerSqFoot, laborCostPerSqFoot);
        testOrder.setProduct(prodObj);

        BigDecimal area = new BigDecimal("100.0");
        testOrder.setArea(area);

        BigDecimal materialCost = new BigDecimal("515.00");
        testOrder.setMaterialCost(materialCost);

        BigDecimal laborCost = new BigDecimal("475.00");
        testOrder.setLaborCost(laborCost);

        BigDecimal taxAmt = new BigDecimal("61.88");
        testOrder.setTaxAmount(taxAmt);

        BigDecimal total = new BigDecimal("1051.88");
        testOrder.setTotal(total);

        OrderRequest changeOrder = new OrderRequest("Tom", "", "", BigDecimal.ZERO);

        OrderResponse response = service.editOrder(testOrder, changeOrder);

        assertEquals("Tom", response.getOrder().get(0).getCustomerName());

    }

    /**
     * Test of removeOrder method, of class FlooringOrders.
     */
    @Test
    public void testRemoveOrder() {

        Order testOrder = createdOrder();
        
        service.removeOrder(LocalDate.parse("2017-09-25"),testOrder);
        
        OrderResponse response = service.searchForOrders(1,LocalDate.parse("2017-09-25"), 0, "");
        
        assertEquals(0, response.getOrder().size());
    }


    /**
     * Test of save method, of class FlooringOrders.
     */
    @Test
    public void testSave() {
    }

}
