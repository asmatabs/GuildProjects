/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;

/**
 *
 * @author asmat
 */
public interface SHSightingsLocationDao {
    
    Location getLocationById(Long id);
    Location addLocation(Location location);
    Location updateLocation(Location location);
    Location removeLocation(Long id);
}
