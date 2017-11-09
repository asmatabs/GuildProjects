/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author asmat
 */
public class SHSightingsOrganizationDaoImpl implements SHSightingsOrganizationDao {

    Session session = null;
    Transaction tx = null;

    @Override
    public Organization getOrganizationById(long id) {
        try {
            session = HibernateUtil.getSession();
            return session.get(Organization.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        try {
            session = HibernateUtil.getSession();
            return session.createQuery("Select o from Organization o").list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Organization addOrganization(Organization organization) {
        try {
            session = HibernateUtil.getSession();
            session.saveOrUpdate(organization);
            return organization;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(organization);
            return organization;
        } finally {
            tx.commit();
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Organization removeOrganization(long id) {
        try {
            session = HibernateUtil.getSession();
            Organization org = session.get(Organization.class, id);
            Organization deletedOrg = org;
            session.delete(org);
            return deletedOrg;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
