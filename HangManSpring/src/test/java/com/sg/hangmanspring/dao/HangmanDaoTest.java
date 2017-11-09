/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangmanspring.dao;

import com.sg.hangmanspring.model.Word;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author asmat
 */
public class HangmanDaoTest {

    private HangmanDao hangmanDao;
    public HangmanDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        hangmanDao = ctx.getBean("hangmanDao", HangmanDao.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class HangmanDao.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of getWordBySize method, of class HangmanDao.
     */
    @Test
    public void testGetWordBySize() {
        List<Word> words = hangmanDao.getWordBySize(3);
    }

}
