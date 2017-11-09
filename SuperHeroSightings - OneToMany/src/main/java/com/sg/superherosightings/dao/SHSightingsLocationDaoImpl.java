/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsLocationDaoImpl implements SHSightingsLocationDao {

    Session session = null;
    Transaction tx = null;

    @Override
    public Location getLocationById(Long id) {
        try {
            session = HibernateUtil.getSession();
            return session.get(Location.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Location addLocation(Location location) {
        try {
            session = HibernateUtil.getSession();
            session.saveOrUpdate(location);
            return location;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Location updateLocation(Location location) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(location);
            return location;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Location removeLocation(Long id) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Location location = session.get(Location.class, id);
            Location deletedLocation = location;
            session.delete(location);
            return deletedLocation;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

}
