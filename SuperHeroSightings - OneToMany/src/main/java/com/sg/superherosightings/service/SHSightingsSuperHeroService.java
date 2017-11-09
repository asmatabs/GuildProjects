/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SHSightingsSuperHeroDao;
import com.sg.superherosightings.model.SuperHero;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author asmat
 */
public class SHSightingsSuperHeroService {
    
    @Inject
    SHSightingsSuperHeroDao superHeroDao;
    
    public void addSuperHero(SuperHero superHero)
    {
        
        if (superHero.getSuperHeroOrgs().size() < 1)
        {
            //Error
        }
        if (superHero.getSuperHeroPowers().size() < 1)
        {
            //Error
        }
        
        superHeroDao.addSuperHero(superHero);
        
    }
    
    public List<SuperHero> retrieveAllSuperHeros()
    {
        return superHeroDao.getAllSuperHeros();
    }
}
