/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.service.SHSightingsSuperHeroService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asmat
 */
@CrossOrigin
@Controller
@RequestMapping({"/superhero"})
public class SHSightingsSuperHeroController {
    
    SHSightingsSuperHeroService superHeroService;
    
    @Inject
    public SHSightingsSuperHeroController(SHSightingsSuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperHero> showSuperHeros()
    {
        return superHeroService.retrieveAllSuperHeros();
    }    
    
    
}
