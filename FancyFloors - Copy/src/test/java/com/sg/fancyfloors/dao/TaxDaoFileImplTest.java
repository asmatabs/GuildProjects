/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author asmat
 */
public class TaxDaoFileImplTest {

    TaxDao taxDao = new TaxDaoFileImpl();

    public TaxDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FilePersistenceException {
        //taxDao.initialize();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTaxByState method, of class TaxDaoFileImpl.
     */
    @Test
    public void testGetTaxByStateSuccess() {

        Tax testTaxObj = new Tax("OH", BigDecimal.valueOf(6.25));
        assertEquals(testTaxObj, taxDao.getTaxByState("OH"));
    }

    @Test
    public void testGetTaxByStateFailure() {

        Tax testTaxObj = new Tax("", BigDecimal.valueOf(6.25));
        assertNull(taxDao.getTaxByState("AB"));
    }

}
