/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author asmat
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException ex) {
            System.out.println("SessionFactory creation failed with error" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
//        Session session = sessionFactory.getCurrentSession();
//        if (session == null) {
//            session = sessionFactory.openSession();
//        }
        return sessionFactory.openSession();
    }

    public static void shutDown() {
        sessionFactory.close();
    }
}
