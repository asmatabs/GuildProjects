/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspring.dao;

import com.sg.dvdlibraryspring.model.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author asmat
 */
public class DvdLibraryDaoDbImplTest {
    
    DvdLibraryDao dao;
    public DvdLibraryDaoDbImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dvdDao", DvdLibraryDao.class);
        
        List<Dvd> dvds = dao.getAllDvds();
        dvds.forEach((dvd) -> {
            dao.removeDvd(dvd.getTitle());
        });
    }
    
    @Test
    public void testAddDvd() {
        
        Dvd newDvd = new Dvd();
        newDvd.setTitle("Iceage");
        newDvd.setMpaaRating("PG-13");
        newDvd.setDirector("John Hopkins");
        newDvd.setReleaseDate(LocalDate.parse("2004-12-01", DateTimeFormatter.ISO_DATE));
        newDvd.setStudio("Universal");
        newDvd.setNote("Some note");
        
        dao.addDvd(newDvd);
        
        Dvd fromDao = dao.getDvdById(newDvd.getDvdId());
        
        assertEquals(fromDao, newDvd);
        
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDaoDbImpl.
     */
    @Test
    public void testRemoveDvd() {
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDaoDbImpl.
     */
    @Test
    public void testGetAllDvds() {
    }

    /**
     * Test of getDvdById method, of class DvdLibraryDaoDbImpl.
     */
    @Test
    public void testGetDvdById() {
    }
    
}
