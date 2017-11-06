/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperPower;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface SHSightingsSuperPowerDao {
    
    SuperPower getById(Long id);
    List<SuperPower> getAll();
    SuperPower add(SuperPower superPower);
    void delete(Long id)  throws Exception ;
    
}
