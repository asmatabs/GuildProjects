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
import org.hibernate.query.Query;

/**
 *
 * @author asmat
 */
public class SHSightingsOrganizationDaoImpl implements SHSightingsOrganizationDao {

    Transaction tx = null;

    @Override
    public Organization getById(long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Organization.class, id);
        }
    }

    @Override
    public List<Organization> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("Select o from Organization o").list();
        } 
    }

    @Override
    public Organization add(Organization organization) {
        try (Session session = HibernateUtil.getSession()) {
            session.saveOrUpdate(organization);
            return organization;
        } 
    }

    @Override
    public Organization update(Organization organization) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.update(organization);
            session.flush();
            tx.commit();
            return organization;
        }
    }

    @Override
    public void delete(long id) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            Organization org = getById(id);
            session.delete(org);
            tx.commit();
        } 
    }
     @Override
    public void deleteSuperHeroOrgs(long id) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery("DELETE FROM SuperHeroOrg WHERE OrgId = :orgId");
            query.setParameter("orgId", id);
            query.executeUpdate();
            tx.commit();
        } 
    }
}
