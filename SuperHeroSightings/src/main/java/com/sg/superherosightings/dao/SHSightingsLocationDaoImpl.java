/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsLocationDaoImpl implements SHSightingsLocationDao {

    Transaction tx = null;

    @Override
    public Location getById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Location.class, id);
        }
    }

    @Override
    public List<Location> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            List<Location> locations = session.createQuery("SELECT l FROM Location l").list();
            return locations;
        }
    }

    @Override
    public Location add(Location location) {
        try (Session session = HibernateUtil.getSession()) {
            session.saveOrUpdate(location);
            return location;
        }
    }

    @Override
    public Location update(Location location) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.update(location);
            session.flush();
            tx.commit();
            return location;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            Location location = session.get(Location.class, id);
            session.delete(location);
            session.flush();
            tx.commit();
        }
    }

}
