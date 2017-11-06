///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.superherosightings.dao;
//
//import com.sg.superherosightings.model.Organization;
//import java.util.List;
//import java.util.function.LongToIntFunction;
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
//public class SHSightingsOrganizationDaoTest {
//
//    SHSightingsOrganizationDao organizationDao;
//    SHSightingsAddressDao addressDao;
//    
//    public SHSightingsOrganizationDaoTest() {
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
//        organizationDao = ctx.getBean("organizationDao", SHSightingsOrganizationDao.class);
//        addressDao = ctx.getBean("addressDao", SHSightingsAddressDao.class);
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getOrganizationById method, of class SHSightingsOrganizationDao.
//     */
//    @Test
//    public void testGetOrganizationById() {
//        Organization org = organizationDao.getOrganizationById(2);
//        assertEquals(org.getName(), "Avengers");
//    }
//
//    /**
//     * Test of getAllOrganizations method, of class SHSightingsOrganizationDao.
//     */
//    @Test
//    public void testGetAllOrganizations() {
//        List<Organization> orgs = organizationDao.getAllOrganizations();
//        assertNotNull(orgs.size());
//    }
//
//    /**
//     * Test of addOrganization method, of class SHSightingsOrganizationDao.
//     */
//    @Test
//    public void testAddOrganization() {
//        Organization newOrg = new Organization();
//        newOrg.setName("Fearless Heros");
//        newOrg.setDescription("Group of fearless men");
//        newOrg.setAddress(addressDao.getAddressById(Long.parseLong("25")));
//        
//        organizationDao.addOrganization(newOrg);
//        Organization fromDao = organizationDao.getOrganizationById(newOrg.getOrgId());
//        assertEquals(newOrg.getName(), fromDao.getName());
//    }
//
//    /**
//     * Test of updateOrganization method, of class SHSightingsOrganizationDao.
//     */
//    @Test
//    public void testUpdateOrganization() {
//        Organization org = organizationDao.getOrganizationById(1);
//        org.setName("The Fantastic Six");
//        
//        Organization updatedOrg = organizationDao.updateOrganization(org);
//        assertEquals(updatedOrg.getName(), "The Fantastic Six");
//    }
//
//    /**
//     * Test of removeOrganization method, of class SHSightingsOrganizationDao.
//     */
//    @Test
//    public void testRemoveOrganization() {
//    }
//}
