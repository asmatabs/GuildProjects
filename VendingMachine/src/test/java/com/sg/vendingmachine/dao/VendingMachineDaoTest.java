/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VendingMachineDaoTest {

    VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
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
            dao.loadInventory();
             dao.loadPricingInfo();
        } catch (VMPersistenceException ex) {
            Logger.getLogger(VendingMachineDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItemsWithPrices method, of class VendingMachineDao.
     */
    @Test
    public void testGetItemPrice() {
        int option = 0;
        ItemPrice itemPrice = new ItemPrice("Snickers", BigDecimal.valueOf(1.99));
        assertEquals(itemPrice, dao.getItemPrice(0));
    }

    /**
     * Test of removeItem method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItem() {
        Map<String, List<Item>> testItems = dao.getItems();
        
        String itemName = "Oreos";
        assertEquals(2,testItems.get(itemName).size() );
        
        Item testItem = dao.getItem(itemName);
        dao.removeItem(testItem);
     
        assertEquals(1,testItems.get(itemName).size() );
    }
}
