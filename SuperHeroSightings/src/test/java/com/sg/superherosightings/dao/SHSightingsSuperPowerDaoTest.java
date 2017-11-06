///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.SuperPower;
//import java.lang.invoke.MethodHandles;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author asmat
// */
//public class SHSightingsSuperPowerDaoTest {
//
//    SHSightingsSuperPowerDao superPowerDao;
//
//    public SHSightingsSuperPowerDaoTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        superPowerDao = ctx.getBean("superPowerDao", SHSightingsSuperPowerDao.class);
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getSuperPowerById method, of class SHSightingsSuperPowerDao.
//     */
//    @Test
//    public void testGetSuperPowerById() {
//        SuperPower superPower = superPowerDao.getById(Long.parseLong("1"));
//        assertEquals(superPower.getPower(), "Teleportation");
//    }
//
//    /**
//     * Test of getAllSuperPowers method, of class SHSightingsSuperPowerDao.
//     */
//    @Test
//    public void testGetAllSuperPowers() {
//        List<SuperPower> superPowers = superPowerDao.getAll();
//        assertNotNull(superPowers.size());
//    }
//
//    @Test
//    public void testAddSuperPower() {
//        SuperPower superPower = new SuperPower();
//        superPower.setPower("Jump high");
//        superPower.setDescription("I can jump really high");
//        SuperPower superPowerAdded = superPowerDao.add(superPower);
//        assertEquals(superPowerAdded, superPower);
//    }
//
//    @Test
//    public void testRemoveSuperPowerSuccess() {
//
//        int sizeBefore = superPowerDao.getAll().size();
//        try {
//            superPowerDao.delete(Long.parseLong("2"));
//        } catch (Exception ex) {
//            fail("Super power should be deleted");
//        }
//        int sizeAfter = superPowerDao.getAll().size();
//        assertEquals(sizeAfter, sizeBefore - 1);
//    }
//
//    @Test
//    public void testRemoveSuperPowerFailure() {
//
//        try {
//            superPowerDao.delete(Long.parseLong("5"));
//            fail("Test should fail with exception");
//        } catch (Exception ex) {
//
//        }
//
//    }
//
//}
