/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface SHSightingsSightingDao {
    
    List<Sighting> getSightingByDate(LocalDate date);
    List<Sighting> getSightingByLocation(Long locationId);
    List<Sighting> getSightingBySuperHero(Long superHeroId);
    Sighting addSighting(Sighting sighting);
    Sighting removeSighting(long id);
}
