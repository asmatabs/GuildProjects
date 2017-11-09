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
    
    Organization getOrganizationById(long id);
    List<Organization> getAllOrganizations();
    Organization addOrganization(Organization organization);
    Organization updateOrganization(Organization organization);
    Organization removeOrganization(long id);
}
