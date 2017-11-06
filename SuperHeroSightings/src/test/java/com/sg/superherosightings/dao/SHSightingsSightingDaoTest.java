///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.Location;
//import com.sg.superherosightings.model.Sighting;
//import com.sg.superherosightings.model.SuperHero;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
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
//public class SHSightingsSightingDaoTest {
//
//    SHSightingsSightingDao sightingDao;
//    SHSightingsLocationDao locationDao;
//    SHSightingsSuperHeroDao superheroDao;
//
//    public SHSightingsSightingDaoTest() {
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
//        sightingDao = ctx.getBean("sightingDao", SHSightingsSightingDao.class);
//        locationDao = ctx.getBean("locationDao", SHSightingsLocationDao.class);
//        superheroDao = ctx.getBean("superheroDao", SHSightingsSuperHeroDao.class);
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getSightingByDate method, of class SHSightingsSightingDao.
//     */
//    @Test
//    public void testGetSightingByDate() {
//
//        List<Sighting> sightings = sightingDao.getByDate(LocalDate.parse("2017-10-01", DateTimeFormatter.ISO_DATE));
//        assertEquals(sightings.size(), 2);
//    }
//
//    /**
//     * Test of getSightingByLocation method, of class SHSightingsSightingDao.
//     */
//    @Test
//    public void testGetSightingByLocation() {
//
//        List<Sighting> sightings = sightingDao.getByLocation(Long.parseLong("1"));
//        assertEquals(sightings.size(), 3);
//    }
//
//    /**
//     * Test of getSightingBySuperHero method, of class SHSightingsSightingDao.
//     */
//    @Test
//    public void testGetSightingBySuperHero() {
//        
//        List<Sighting> sightings = sightingDao.getBySuperHero(Long.parseLong("1"));
//        assertEquals(sightings.size(), 1);
//    }
//
//    /**
//     * Test of addSighting method, of class SHSightingsSightingDao.
//     */
//    @Test
//    public void testAddSighting() {
//        
//        Sighting sighting = new Sighting();
//        sighting.setLocation(locationDao.getById(Long.parseLong("1")));
//        sighting.setSightingSuperHero(superheroDao.getById(Long.parseLong("4")));
//        sighting.setDateSighted(LocalDate.now());
//        
//        Sighting sightingRet = sightingDao.add(sighting);
//        
//        assertEquals(sighting.getSightingId(), sightingRet.getSightingId());
//    }
//
//    /**
//     * Test of removeSighting method, of class SHSightingsSightingDao.
//     */
//    @Test
//    public void testRemoveSighting() {
//        
//    }
//}
