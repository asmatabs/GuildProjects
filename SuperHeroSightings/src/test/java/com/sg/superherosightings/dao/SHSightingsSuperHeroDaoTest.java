///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.Organization;
//import com.sg.superherosightings.model.SuperHero;
//import com.sg.superherosightings.model.SuperPower;
//import com.sg.superherosightings.util.DatabaseInitializer;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author asmat
// */
//public class SHSightingsSuperHeroDaoTest {
//
//    SHSightingsSuperHeroDao superheroDao;
//    SHSightingsOrganizationDao organizationDao;
//    SHSightingsSuperPowerDao superPowerDao;
//
//    public SHSightingsSuperHeroDaoTest() {
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
//        superheroDao = ctx.getBean("superheroDao", SHSightingsSuperHeroDao.class);
//        organizationDao = ctx.getBean("organizationDao", SHSightingsOrganizationDao.class);
//        superPowerDao = ctx.getBean("superPowerDao", SHSightingsSuperPowerDao.class);
//        
//       // DatabaseInitializer.setKnownGoodState();
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getSuperHeroById method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testGetSuperHeroById() {
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Spider-man 2");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//        superheroDao.add(hero);
//        long id = hero.getSuperHeroId();
//        SuperHero myhero = superheroDao.getById(id);
//        assertEquals(myhero, hero);
//    }
//
//    /**
//     * Test of addSuperHero method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testAddSuperHero() {
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Spider-man 3");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//
//        Organization myOrg = organizationDao.getById(2);
//        Set<Organization> superHeroOrgs = new HashSet<>();
//        superHeroOrgs.add(myOrg);
//        hero.setSuperHeroOrgs(superHeroOrgs);
//        
//        SuperPower superPower = superPowerDao.getById(Long.parseLong("1"));
//        Set<SuperPower> superHeroPowers = new HashSet<>();
//        superHeroPowers.add(superPower);
//        hero.setSuperHeroPowers(superHeroPowers);
//        superheroDao.add(hero);
//
//        List<SuperHero> myHeros = superheroDao.getAll();
//        assertEquals(hero, myHeros.get(myHeros.size() - 1));
//    }
//
//    /**
//     * Test of updateSuperHero method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testUpdateSuperHero() {
//        SuperHero hero = superheroDao.getById(Long.parseLong("1"));
//
//
//        hero.setGender("Female");
//        superheroDao.update(hero);
//        SuperHero updatedHero = superheroDao.getById(hero.getSuperHeroId());
//        assertEquals(hero.getGender(), updatedHero.getGender());
//    }
//
//    /**
//     * Test of getAllSuperHeros method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testGetAllSuperHeros() {
//
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Wonder woman");
//        hero.setDescription(" ");
//        hero.setGender("Female");
//        int sizeBefore = superheroDao.getAll().size();
//        superheroDao.add(hero);
//        int sizeAfter = superheroDao.getAll().size();
//        assertEquals(sizeAfter, sizeBefore + 1);
//    }
//
//    @Test
//    public void testRemoveSuperHero() {
//
//        int sizeBefore = superheroDao.getAll().size();
//        superheroDao.delete(Long.parseLong("5"));
//        int sizeAfter = superheroDao.getAll().size();
//        assertEquals(sizeAfter, sizeBefore - 1);
//    }
//
//}
