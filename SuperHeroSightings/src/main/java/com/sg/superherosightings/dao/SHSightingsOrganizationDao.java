/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Organization;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface SHSightingsOrganizationDao {
    
    Organization getById(long id);
    List<Organization> getAll();
    Organization add(Organization organization);
    Organization update(Organization organization);
    void delete(long id);
}
