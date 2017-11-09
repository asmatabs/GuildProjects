/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author asmat
 */
public class SHSightingsSightingDaoImpl implements SHSightingsSightingDao {

    Transaction tx = null;
    Session session = null;

    @Override
    public List<Sighting> getSightingByDate(LocalDate date) {
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("SELECT s FROM Sighting s WHERE s.dateSighted = :date");
            query.setParameter("date", date);

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Sighting> getSightingByLocation(Long locationId) {
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("SELECT s FROM Sighting s WHERE s.location.locationId = :locationId");
            query.setParameter("locationId", locationId);

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Sighting> getSightingBySuperHero(Long superHeroId) {
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("SELECT s FROM Sighting s WHERE s.sightingSuperHero.superHeroId = :superHeroId");
            query.setParameter("superHeroId", superHeroId);

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Sighting addSighting(Sighting sighting) {
        try {
            session = HibernateUtil.getSession();
            session.saveOrUpdate(sighting);
            return sighting;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Sighting removeSighting(long id) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Sighting sighting = session.get(Sighting.class,
                    id);
            Sighting deletedSighting = sighting;
            session.delete(sighting);
            session.flush();
            return deletedSighting;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

}
