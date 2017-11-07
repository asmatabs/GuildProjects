/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
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

    private static final String QUERY_GET_SIGHTINGS_BY_HERO_ID = "select s from Sighting s "
            + "inner join s.superHero sh "
            + "where sh.superHeroId = :superHeroId ";

    Transaction tx = null;

    @Override
    public List<Sighting> getByDate(LocalDate date) {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("SELECT s FROM Sighting s WHERE s.dateSighted = :date");
            query.setParameter("date", date);

            return query.list();
        }
    }

    @Override
    public List<Sighting> getByLocation(Long locationId) {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("SELECT s FROM Sighting s WHERE s.location.locationId = :locationId");
            query.setParameter("locationId", locationId);

            return query.list();
        }
    }

    @Override
    public List<Sighting> getByLocationAndDate(Long locationId, LocalDate date) {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("SELECT s FROM Sighting s "
                    + "WHERE s.location.locationId = :locationId "
                    + "AND s.dateSighted = :date");
            query.setParameter("locationId", locationId);
            query.setParameter("date", date);

            return query.list();
        }
    }

    @Override
    public List<Sighting> getBySuperHero(Long superHeroId) {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery(QUERY_GET_SIGHTINGS_BY_HERO_ID);
            query.setParameter("superHeroId", superHeroId);

            return query.list();
        }
    }

    @Override
    public Sighting add(Sighting sighting) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(sighting);
            session.flush();
            tx.commit();
            return sighting;
        }
    }

    @Override
    public void delete(long id) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            Sighting sighting = session.get(Sighting.class,
                    id);
            session.delete(sighting);
            session.flush();
            tx.commit();
        }
    }

    @Override
    public List<Sighting> getTopTenSightings() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("SELECT s FROM Sighting s order by s.dateSighted desc");
            query.setMaxResults(10);
            return query.list();
        }
    }

    @Override
    public List<Sighting> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("SELECT s FROM Sighting s");
            return query.list();
        }
    }
}
