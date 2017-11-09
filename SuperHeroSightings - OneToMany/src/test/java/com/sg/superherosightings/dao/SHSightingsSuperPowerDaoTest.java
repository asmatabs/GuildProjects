///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.SuperPower;
//import java.util.List;
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
//        SuperPower superPower = superPowerDao.getSuperPowerById(Long.parseLong("1"));
//        assertEquals(superPower.getPower(), "Teleportation");
//    }
//
//    /**
//     * Test of getAllSuperPowers method, of class SHSightingsSuperPowerDao.
//     */
//    @Test
//    public void testGetAllSuperPowers() {
//        List<SuperPower> superPowers = superPowerDao.getAllSuperPowers();
//        assertEquals(superPowers.size(), 10);
//    }
//}
