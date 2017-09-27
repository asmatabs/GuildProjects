/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;
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
public class DvdLibraryDaoTest {

    DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public DvdLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        List<Dvd> dvds = dao.getAllDvds();
        dvds.forEach((newDvd) -> {
            dvds.remove(newDvd.getTitle());
        });
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testAddDvd() {
        Dvd dvd = new Dvd();
        dvd.setTitle("Ice Age");
        dvd.setDirector("Tom");
        dvd.setMpaaRating("G");
        dvd.setNote("");
        dvd.setStudio("Pixar");
        dvd.setReleaseDate("13 Sept 2008");

        dao.addDvd(dvd.getTitle(), dvd);

        Dvd newDvd = dao.getDvd("Ice Age");
        assertEquals(newDvd, dvd);
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     */
    @Test
    public void testRemoveDvd() {
        Dvd dvd = new Dvd();
        dvd.setTitle("Ice Age");
        dvd.setDirector("Tom");
        dvd.setMpaaRating("G");
        dvd.setNote("");
        dvd.setStudio("Pixar");
        dvd.setReleaseDate("13 Sept 2008");

        dao.addDvd(dvd.getTitle(), dvd);
        assertEquals(1, dao.getAllDvds().size());

        dao.removeDvd(dvd.getTitle());
        assertEquals(0, dao.getAllDvds().size());

    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     */
    @Test
    public void testGetAllDvds() {
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Ice Age");
        dvd1.setDirector("Tom");
        dvd1.setMpaaRating("G");
        dvd1.setNote("");
        dvd1.setStudio("Pixar");
        dvd1.setReleaseDate("13 Sept 2008");

        dao.addDvd(dvd1.getTitle(), dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("Ice Age 2");
        dvd2.setDirector("Tom");
        dvd2.setMpaaRating("G");
        dvd2.setNote("");
        dvd2.setStudio("Pixar");
        dvd2.setReleaseDate("13 Sept 2008");

        dao.addDvd(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of checkDVDExists method, of class DvdLibraryDao.
     */
    @Test
    public void testCheckDVDExists() {
        Dvd dvd = new Dvd();
        dvd.setTitle("Ice Age");
        dvd.setDirector("Tom");
        dvd.setMpaaRating("G");
        dvd.setNote("");
        dvd.setStudio("Pixar");
        dvd.setReleaseDate("13 Sept 2008");

        dao.addDvd(dvd.getTitle(), dvd);
        assertTrue(dao.checkDVDExists(dvd.getTitle()));
    }

}
