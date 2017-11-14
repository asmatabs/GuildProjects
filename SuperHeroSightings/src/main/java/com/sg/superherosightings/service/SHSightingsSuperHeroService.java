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

    public SuperHero retrieveSuperHeroById(long id) {
        return superHeroDao.getById(id);
    }

    public List<SuperHero> retrieveAllSuperHeros() {
        return superHeroDao.getAll();
    }

    public SuperHero saveSuperHero(SuperHero superHero) {
        return superHeroDao.add(superHero);
    }

    public SuperHero updateSuperHero(SuperHero superhero) {
        return superHeroDao.update(superhero);
    }

    public void removeSuperHero(long id) {
        superHeroDao.delete(id);
    }

}
