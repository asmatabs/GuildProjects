/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author asmat
 */
public class SHSightingsSuperHeroDaoImpl implements SHSightingsSuperHeroDao {

    Transaction tx = null;

    @Override
    public SuperHero getById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(SuperHero.class, id);
        }
    }

    @Override
    public List<SuperHero> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            List<SuperHero> heros = session.createQuery("SELECT s FROM SuperHero s").list();
            return heros;
        }
    }

    @Override
    public SuperHero add(SuperHero superHero) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(superHero);
            session.flush();
            tx.commit();
        }
        return superHero;
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.update(superHero);
            session.flush();
            tx.commit();
            return superHero;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            SuperHero hero = getById(id);

            Query query = session.createNativeQuery("DELETE FROM SuperHeroOrg WHERE SuperHeroId = :superHeroId");
            query.setParameter("superHeroId", id);
            query.executeUpdate();

            query = session.createNativeQuery("DELETE FROM SuperHeroPowers WHERE SuperHeroId = :superHeroId");
            query.setParameter("superHeroId", id);
            query.executeUpdate();

            query = session.createNativeQuery("DELETE FROM SightingHero WHERE SuperHeroId = :superHeroId");
            query.setParameter("superHeroId", id);
            query.executeUpdate();

            session.delete(hero);
            session.flush();
            tx.commit();
        }
    }
}
