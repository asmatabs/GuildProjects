/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.sg.vendingmachine.dao.ItemsDao;
import com.sg.vendingmachine.dao.ItemsDaoStubImpl;
import com.sg.vendingmachine.dto.Item;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 *
 * @author asmat
 */
public class VendingMachineTest {

    ItemsDao dao = new ItemsDaoStubImpl();
    VendingMachine service = new VendingMachineImpl(dao);

    public VendingMachineTest() {
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
     * Test of getItemFromInventory method, of class VendingMachine.
     */
    @Test
    public void testVendItemSuccess() throws Exception {
        Money money = new Money(BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(1),
                BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Item onlyItem = new Item();
        onlyItem.setItemId("SNIC101");
        onlyItem.setName("Snickers");

        LocalDate manfDate;
        manfDate = LocalDate.parse("2017-07-11");
        onlyItem.setManufacturerDate(manfDate);
        onlyItem.setNutriInfo("110 calories");

        assertEquals(onlyItem, service.vendItem("Snickers", money));

    }

    @Test
    public void testVendItemInSufficientFunds() throws Exception {
        Money money = new Money(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(1),
                BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Item onlyItem;

        try {
            onlyItem = service.vendItem("Snickers", money);
            fail("Funds insufficient to buy item");
        } catch (InsufficientFundsException ex) {
            //Pass
        }
    }

    /**
     * Test of validatePayment method, of class VendingMachine.
     */
    @Test
    public void testValidatePaymentSuccess() {
        Money money = new Money(BigDecimal.valueOf(2),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(2));

        assertTrue(service.validatePayment(money));
    }
    
        @Test
    public void testValidatePaymentFailure() {
        Money money = new Money(BigDecimal.valueOf(0),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0));

        assertFalse(service.validatePayment(money));
    }

    /**
     * Test of calculateChange method, of class VendingMachine.
     */
    @Test
    public void testDispenseChange() {
        Money money = new Money(BigDecimal.valueOf(2),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(2));
        
        Money change = service.dispenseChange(money, true);
        
        if(change.getTotalAmount().intValue() == 0){
            fail("Change invalid");
        }
    }
}
