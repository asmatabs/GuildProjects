/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.ItemPrice;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
public class ItemsDaoTest {

    ItemsDao dao = new ItemsDaoFileImpl();

    public ItemsDaoTest() {
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
        } catch (FilePersistenceException ex) {
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getItemsWithPrices method, of class ItemsDao.
     */
    @Test
    public void testGetItemPriceSuccess() {
        ItemPrice itemPrice = new ItemPrice("Snickers", BigDecimal.valueOf(1.99));
        assertEquals(itemPrice, dao.getItemPrice("Snickers"));
    }

    public void testGetItemPriceFailure() {

        assertNull(dao.getItemPrice("Coke"));
    }

    /**
     * Test of removeItem method, of class ItemsDao.
     */
    @Test
    public void testRemoveItemSuccess() {
        /* Make sure there is altleast one 'Oreos' in the items.csv file before testing */

        Map<String, List<Item>> testItems = dao.getItems();

        String itemName = "Oreos";
        int sizeBefore = testItems.get(itemName).size();

        Item testItem = dao.getItem(itemName);
        dao.removeItem(testItem);

        int sizeAfter = testItems.get(itemName).size();
        if (sizeAfter != sizeBefore - 1) {
            fail("Sizes dont match up after remove");
        }
    }
    
        @Test
    public void testRemoveItemFailure() {
        /* Make sure there is altleast one 'Oreos' in the items.csv file before testing 
        No Assert required. Test Pass as long as no Null Pointer Exception */
        
        Map<String, List<Item>> testItems = dao.getItems();

        String itemName = "Coke";
        Item testItem = new Item();
        testItem.setItemId("COKE101");
        testItem.setName("Coke");
        testItem.setManufacturerDate(LocalDate.MIN);
        dao.removeItem(testItem);
    }
    
    @Test
    public void testGetItemSuccess(){
        
        Item currentItem = new Item();
                currentItem.setItemId("SNICTEST101");
        currentItem.setName("Snickers");
        LocalDate manuDate = LocalDate.parse("2017-01-12");
        currentItem.setManufacturerDate(manuDate);
        currentItem.setNutriInfo("100 calories");
        
        assertEquals(currentItem, dao.getItem("Snickers"));
    }
            
}
