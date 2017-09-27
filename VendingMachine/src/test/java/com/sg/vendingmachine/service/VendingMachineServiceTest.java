/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dto.Money;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author asmat
 */
public class VendingMachineServiceTest {

    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    VendingMachineService service = new VendingMachineServiceImpl(dao);

    public VendingMachineServiceTest() {
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
     * Test of getItemFromInventory method, of class VendingMachineService.
     */
    @Test
    public void testGetItemFromInventory() throws Exception {
    }

    /**
     * Test of validatePayment method, of class VendingMachineService.
     */
    @Test
    public void testValidatePayment() {
        Money money = new Money(BigDecimal.valueOf(2),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(2));

        assertTrue(service.validatePayment(money));
    }

    /**
     * Test of calculateChange method, of class VendingMachineService.
     */
    @Test
    public void testCalculateChange() {
        Money money = new Money(BigDecimal.valueOf(2),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(2),
                BigDecimal.valueOf(2));
        money.setChangeDue(BigDecimal.valueOf(1));
        
        Money change = service.calculateChange(money);
        
        assertEquals(BigDecimal.valueOf(1), change.getDollar());
    }
}
