/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SHSightingsOrganizationDao;
import com.sg.superherosightings.dao.SHSightingsSightingDao;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.model.SuperPower;
import com.sg.superherosightings.model.request.SuperHeroRequest;
import com.sg.superherosightings.service.SHSightingsSuperHeroService;
import com.sg.superherosightings.service.SHSightingsSuperPowerService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author asmat
 */
@CrossOrigin
@Controller
@RequestMapping({"/superhero"})
public class SHSightingsSuperHeroController {

    SHSightingsSuperHeroService superHeroService;
    SHSightingsSuperPowerService superPowerService;
    SHSightingsOrganizationDao organizationDao;

    @Inject
    public SHSightingsSuperHeroController(SHSightingsSuperHeroService superHeroService, SHSightingsSuperPowerService superPowerService, SHSightingsOrganizationDao organizationDao) {
        this.superHeroService = superHeroService;
        this.superPowerService = superPowerService;
        this.organizationDao = organizationDao;
    }

    @RequestMapping(value = "/heros", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperHero> showSuperHeros() {
        return superHeroService.retrieveAllSuperHeros();
    }

    @RequestMapping(value = "/hero/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SuperHero showSuperHeroById(@PathVariable("id") long id) {
        return superHeroService.retrieveSuperHeroById(id);
    }

    @RequestMapping(value = "/hero", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SuperHero createSuperHero(@Valid @RequestBody SuperHeroRequest superHeroReq) {

        SuperHero superHero;
        if (superHeroReq.getSuperHeroId() == 0) {
            superHero = new SuperHero();
        } else {
            superHero = superHeroService.retrieveSuperHeroById(superHeroReq.getSuperHeroId());
        }
        superHero.setSuperName(superHeroReq.getSuperName());
        superHero.setDescription(superHeroReq.getDescription());
        superHero.setGender(superHeroReq.getGender());

        Set<SuperPower> superHeroPowers = new HashSet<>();
        String[] tokens = superHeroReq.getPowers().split(",");
        for (String token : tokens) {
            superHeroPowers.add(superPowerService.getSuperPower(Long.parseLong(token)));
        }

        Set<Organization> superHeroOrgs = new HashSet<>();
        tokens = superHeroReq.getOrgs().split(",");
        for (String token : tokens) {
            superHeroOrgs.add(organizationDao.getById(Long.parseLong(token)));
        }
        superHero.setSuperHeroPowers(superHeroPowers);
        superHero.setSuperHeroOrgs(superHeroOrgs);
        return superHeroService.saveSuperHero(superHero);
    }

    @RequestMapping(value = "/hero{id}", method = RequestMethod.PUT)
    @ResponseBody
    public SuperHero updateSuperHero(@PathVariable("id") long id, @Valid @RequestBody SuperHero superHero) {
        return superHeroService.updateSuperHero(superHero);
    }

    @RequestMapping(value = "/hero/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSuperHero(@PathVariable("id") long id) {

        superHeroService.removeSuperHero(id);
    }
}
