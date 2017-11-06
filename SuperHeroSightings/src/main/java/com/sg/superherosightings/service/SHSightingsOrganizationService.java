/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SHSightingsOrganizationDao;
import com.sg.superherosightings.model.Organization;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author asmat
 */
public class SHSightingsOrganizationService {

    SHSightingsOrganizationDao orgDao;

    @Inject
    public SHSightingsOrganizationService(SHSightingsOrganizationDao orgDao) {
        this.orgDao = orgDao;
    }

    public Organization createOrganization(Organization org) {

        return orgDao.add(org);
    }

    public Organization getOrganization(long id) {

        return orgDao.getById(id);
    }

    public List<Organization> retrieveAllOrganizations() {
        return orgDao.getAll();
    }

    public void removeOrganization(long id) {
        orgDao.delete(id);
    }

}
