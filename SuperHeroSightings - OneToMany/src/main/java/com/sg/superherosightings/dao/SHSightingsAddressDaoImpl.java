/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsAddressDaoImpl implements SHSightingsAddressDao {

    Session session = null;
    Transaction tx;

    @Override
    public Address getAddressById(Long id) {
        try {
            session = HibernateUtil.getSession();
            return session.get(Address.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Address addAddress(Address address) {
        try {
            session = HibernateUtil.getSession();
            session.saveOrUpdate(address);
            return address;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Address updateAddress(Address address) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(address);
            return address;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Address deleteAddress(Long id) {
        try {
            session = HibernateUtil.getSession();
            Address address = session.get(Address.class, id);
            Address deletedAddress = address;
            session.delete(address);
            return deletedAddress;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
