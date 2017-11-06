/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SHSightingsSuperPowerDao;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperPower;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author asmat
 */
public class SHSightingsSuperPowerService {
    
    SHSightingsSuperPowerDao superPowerDao;

    @Inject
    public SHSightingsSuperPowerService(SHSightingsSuperPowerDao superPowerDao) {
        this.superPowerDao = superPowerDao;
    }

    public SuperPower createSuperPower(SuperPower superPower) {

        return superPowerDao.add(superPower);
    }

    public SuperPower getSuperPower(long id) {

        return superPowerDao.getById(id);
    }

    public List<SuperPower> retrieveAllSuperPowers() {
        return superPowerDao.getAll();
    }

    public void removeSuperPower(long id) throws Exception {
        superPowerDao.delete(id);
    }
   
}
