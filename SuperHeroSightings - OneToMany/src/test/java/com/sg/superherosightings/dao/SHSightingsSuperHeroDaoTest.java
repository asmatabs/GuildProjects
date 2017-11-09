///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.Address;
//import com.sg.superherosightings.model.Organization;
//import com.sg.superherosightings.model.SuperHero;
//import com.sg.superherosightings.model.SuperHeroOrg;
//import com.sg.superherosightings.model.SuperHeroPowers;
//import com.sg.superherosightings.model.SuperPower;
//import java.util.ArrayList;
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
//        hero.setSuperName("Spider-man");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//        superheroDao.addSuperHero(hero);
//        long id = hero.getSuperHeroId();
//        SuperHero myhero = superheroDao.getSuperHeroById(id);
//        assertEquals(myhero, hero);
//    }
//
//    /**
//     * Test of addSuperHero method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testAddSuperHero() {
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Spider-man");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//
//        Organization myOrg = organizationDao.getOrganizationById(2);
//        SuperHeroOrg org1 = new SuperHeroOrg();
//        org1.setSuperHero(hero);
//        org1.setOrganization(myOrg);
//        Set<SuperHeroOrg> superHeroOrgs = new HashSet<>();
//        superHeroOrgs.add(org1);
//        hero.setSuperHeroOrgs(superHeroOrgs);
//        
//        SuperPower superPower = superPowerDao.getSuperPowerById(Long.parseLong("1"));
//        SuperHeroPowers powers = new SuperHeroPowers();
//        powers.setSuperPowerHero(hero);
//        powers.setSuperPower(superPower);
//        
//        Set<SuperHeroPowers> superHeroPowers = new HashSet<>();
//        superHeroPowers.add(powers);
//        hero.setSuperHeroPowers(superHeroPowers);
//        superheroDao.addSuperHero(hero);
//
//        //superheroDao.addSuperHero(hero);
//        List<SuperHero> myHeros = superheroDao.getAllSuperHeros();
//        assertEquals(hero, myHeros.get(myHeros.size() - 1));
//    }
//
//    /**
//     * Test of updateSuperHero method, of class SHSightingsSuperHeroDaoImpl.
//     */
//    @Test
//    public void testUpdateSuperHero() {
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Spider-man");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//        superheroDao.addSuperHero(hero);
//
//        hero.setGender("Female");
//        superheroDao.updateSuperHero(hero);
//        SuperHero updatedHero = superheroDao.getSuperHeroById(hero.getSuperHeroId());
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
//        hero.setSuperName("Spider-man");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//        int sizeBefore = superheroDao.getAllSuperHeros().size();
//        superheroDao.addSuperHero(hero);
//        int sizeAfter = superheroDao.getAllSuperHeros().size();
//        assertEquals(sizeAfter, sizeBefore + 1);
//    }
//
//    @Test
//    public void testRemoveSuperHero() {
//
//        SuperHero hero = new SuperHero();
//        hero.setSuperName("Spider-man");
//        hero.setDescription("Spider-man can cling to any surface");
//        hero.setGender("Male");
//
//        superheroDao.addSuperHero(hero);
//        int sizeBefore = superheroDao.getAllSuperHeros().size();
//        superheroDao.removeSuperHero(hero.getSuperHeroId());
//        int sizeAfter = superheroDao.getAllSuperHeros().size();
//        assertEquals(sizeAfter, sizeBefore - 1);
//    }
//
//}
