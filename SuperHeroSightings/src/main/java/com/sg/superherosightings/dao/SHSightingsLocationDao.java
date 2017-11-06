/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface SHSightingsLocationDao {
    
    Location getById(Long id);
    List<Location> getAll();
    Location add(Location location);
    Location update(Location location);
    void delete(Long id);
}
