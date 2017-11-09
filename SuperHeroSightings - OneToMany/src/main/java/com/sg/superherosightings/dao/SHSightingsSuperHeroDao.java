/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.SuperHero;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface SHSightingsSuperHeroDao {
    
    SuperHero getSuperHeroById(Long id);
    List<SuperHero> getAllSuperHeros(); 
    SuperHero addSuperHero(SuperHero superHero);
    SuperHero updateSuperHero(SuperHero superHero);
    SuperHero removeSuperHero(Long id);
}
