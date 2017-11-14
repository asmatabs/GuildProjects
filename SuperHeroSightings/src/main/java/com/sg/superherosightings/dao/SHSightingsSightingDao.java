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
    
    Sighting getById(Long id);
    List<Sighting> getAll();
    List<Sighting> getByDate(LocalDate date);
    List<Sighting> getByLocation(Long locationId);
    List<Sighting> getBySuperHero(Long superHeroId);
    List<Sighting> getByLocationAndDate(Long locationId, LocalDate date);
    List<Sighting> getTopTenSightings();
    
    Sighting add(Sighting sighting);
    void delete(long id);
    void deleteByLocation(long id);
}
