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
    
    SuperPower getSuperPowerById(Long id);
    List<SuperPower> getAllSuperPowers();
    
}
