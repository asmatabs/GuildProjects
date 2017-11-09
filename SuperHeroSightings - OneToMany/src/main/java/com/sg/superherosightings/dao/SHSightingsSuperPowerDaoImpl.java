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

/**
 *
 * @author asmat
 */
public class SHSightingsSuperPowerDaoImpl implements SHSightingsSuperPowerDao {

    Session session = null;

    @Override
    public SuperPower getSuperPowerById(Long id) {
        try {
            session = HibernateUtil.getSession();
            return session.get(SuperPower.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        try {
            session = HibernateUtil.getSession();
            return session.createQuery("Select s from SuperPower s").list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
