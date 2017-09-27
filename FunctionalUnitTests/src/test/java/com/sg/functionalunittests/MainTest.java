/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.functionalunittests;

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
public class MainTest {

    Main main = new Main();

    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of commonEnd method, of class Main.
     */
    @Test
    public void testCommonEnd() {

        int[] a = {1, 2, 3};
        int[] b = {7, 3};
        assertTrue(main.commonEnd(a, b));

        int[] x = {1, 2, 3};
        int[] y = {7, 3, 2};

        assertFalse(main.commonEnd(x, y));

        int[] p = {1, 2, 3};
        int[] q = {1, 3};

        assertTrue(main.commonEnd(p, q));
    }

    /**
     * Test of doubleX method, of class Main.
     */
    @Test
    public void testDoubleX() {
        assertTrue(main.doubleX("axxbb"));
        assertFalse(main.doubleX("axaxxax"));
        assertTrue(main.doubleX("xxxxxx"));
        
    }

    @Test
    public void testCaughtSpeeding(){
    assertEquals( 0, main.caughtSpeeding(60, false));
    assertEquals(1, main.caughtSpeeding(65, false));
    assertEquals(0, main.caughtSpeeding(65, true));
    }
}
