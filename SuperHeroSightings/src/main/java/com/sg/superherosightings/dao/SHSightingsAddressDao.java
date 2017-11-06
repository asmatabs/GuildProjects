/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Address;

/**
 *
 * @author asmat
 */
public interface SHSightingsAddressDao {
    
    Address getById(Long id);
    Address add(Address address);
    Address update(Address address);
    void delete(Long id);
}
