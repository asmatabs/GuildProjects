/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPower;
import com.sg.superherosightings.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsSuperPowerDaoImpl implements SHSightingsSuperPowerDao {

    @Override
    public SuperPower getById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(SuperPower.class, id);
        }
    }

    @Override
    public List<SuperPower> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("Select s from SuperPower s").list();
        }
    }

    @Override
    public SuperPower add(SuperPower superPower) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(superPower);
            session.flush();
            tx.commit();
        }
        return superPower;
    }

    @Override
    public void delete(Long id) throws Exception {
        try (Session session = HibernateUtil.getSession()) {
            Transaction deleteTx = session.beginTransaction();
            SuperPower superPower = session.get(SuperPower.class,
                    id);
            session.delete(superPower);
            session.flush();
            deleteTx.commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
