///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.Location;
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
//public class SHSightingsLocationDaoImplTest {
//
//    SHSightingsLocationDao locationDao;
//    SHSightingsAddressDao addressDao;
//
//    public SHSightingsLocationDaoImplTest() {
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
//        locationDao = ctx.getBean("locationDao", SHSightingsLocationDao.class);
//        addressDao = ctx.getBean("addressDao", SHSightingsAddressDao.class);
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getLocationById method, of class SHSightingsLocationDaoImpl.
//     */
//    @Test
//    public void testGetLocationById() {
//        Location loc = locationDao.getLocationById(Long.parseLong("1"));
//        assertEquals(loc.getName(), "Mall of America");
//    }
//
//    /**
//     * Test of addLocation method, of class SHSightingsLocationDaoImpl.
//     */
//    @Test
//    public void testAddLocation() {
//        Location newLoc = new Location();
//        newLoc.setName("Airport Terminal 1");
//        newLoc.setDescription("Airport Terminal 1");
//        newLoc.setAddress(addressDao.getAddressById(Long.parseLong("23")));
//
//        locationDao.addLocation(newLoc);
//        Location fromDao = locationDao.getLocationById(newLoc.getLocationId());
//        assertEquals(newLoc.getName(), fromDao.getName());
//    }
//
//    /**
//     * Test of updateLocation method, of class SHSightingsLocationDaoImpl.
//     */
//    @Test
//    public void testUpdateLocation() {
//        Location location = locationDao.getLocationById(Long.parseLong("1"));
//        location.setName("Southdale mall");
//        
//        Location updatedLoc = locationDao.updateLocation(location);
//        
//        assertEquals(updatedLoc.getName(), "Southdale mall");
//    }
//
//    /**
//     * Test of removeLocation method, of class SHSightingsLocationDaoImpl.
//     */
////    @Test
////    public void testRemoveLocation() {
////        
////        locationDao.removeLocation(Long.parseLong("1"));
////        assertNull(locationDao.getLocationById(Long.parseLong("1")));
////    }
//
//}
