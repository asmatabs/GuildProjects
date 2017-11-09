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
import org.hibernate.Hibernate;
/**
 *
 * @author asmat
 */
public class SHSightingsSuperHeroDaoImpl implements SHSightingsSuperHeroDao {

    Session session = null;
    Transaction tx = null;

    @Override
    public SuperHero getSuperHeroById(Long id) {
        try {
            session = HibernateUtil.getSession();
            return session.get(SuperHero.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public SuperHero addSuperHero(SuperHero superHero) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(superHero);
            session.flush();
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
        return superHero;
    }

    @Override
    public SuperHero updateSuperHero(SuperHero superHero) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(superHero);
            session.flush();
            return superHero;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<SuperHero> getAllSuperHeros() {
        try {
            session = HibernateUtil.getSession();

            List<SuperHero> heros = session.createQuery("SELECT s FROM SuperHero s").list();
            for (SuperHero hero: heros)
            {
                Hibernate.initialize(hero.getSuperHeroOrgs());
            }
            return heros;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public SuperHero removeSuperHero(Long id) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            SuperHero hero = session.get(SuperHero.class,
                    id);
            SuperHero deletedHero = hero;
            session.delete(hero);
            session.flush();
            return deletedHero;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }
}
