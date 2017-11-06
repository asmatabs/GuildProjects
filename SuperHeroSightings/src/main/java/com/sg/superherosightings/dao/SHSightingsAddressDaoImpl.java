/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsAddressDaoImpl implements SHSightingsAddressDao {

    Transaction tx;

    @Override
    public Address getById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Address.class, id);
        }
    }

    @Override
    public Address add(Address address) {
        try (Session session = HibernateUtil.getSession()) {
            session.saveOrUpdate(address);
            return address;
        }
    }

    @Override
    public Address update(Address address) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.update(address);
            session.flush();
            tx.commit();
            return address;
        } 
    }

    @Override
    public void delete(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            Address address = session.get(Address.class, id);
            session.delete(address);
        } 
    }

}
