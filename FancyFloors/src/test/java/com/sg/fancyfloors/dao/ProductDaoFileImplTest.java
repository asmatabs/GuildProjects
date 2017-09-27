/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Product;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asmat
 */
public class ProductDaoFileImplTest {

    ProductDao prodDao = new ProductDaoFileImpl();

    public ProductDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FilePersistenceException {
        prodDao.initialize();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getProductByType method, of class ProductDaoFileImpl.
     */
    @Test
    public void testGetProductByTypeSuccess() {
        BigDecimal costPerSqFeet = new BigDecimal("1.75");
        BigDecimal laborCostPerSqFeet = new BigDecimal("2.10");
        Product testProduct = new Product("Laminate", costPerSqFeet, laborCostPerSqFeet);
        assertEquals(testProduct, prodDao.getProductByType("Laminate"));
    }

    @Test
    public void testGetProductByTypeFailure() {
        BigDecimal costPerSqFeet = new BigDecimal("1.75");
        BigDecimal laborCostPerSqFeet = new BigDecimal("2.10");
        Product testProduct = new Product("Dirt", costPerSqFeet, laborCostPerSqFeet);
        assertNull(prodDao.getProductByType("Dirt"));
    }
}
