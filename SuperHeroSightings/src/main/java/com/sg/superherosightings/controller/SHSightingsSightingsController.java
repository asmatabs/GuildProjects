/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SHSightingsLocationDao;
import com.sg.superherosightings.dao.SHSightingsSightingDao;
import com.sg.superherosightings.dao.SHSightingsSuperHeroDao;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.model.request.SightingRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.QueryHint;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
@RequestMapping({"/sighting"})
public class SHSightingsSightingsController {

    SHSightingsSightingDao sightingsDao;
    SHSightingsLocationDao locationDao;
    SHSightingsSuperHeroDao superheroDao;

    @Inject
    public SHSightingsSightingsController(SHSightingsSightingDao sightingsDao, SHSightingsLocationDao locationDao, SHSightingsSuperHeroDao superheroDao) {
        this.sightingsDao = sightingsDao;
        this.locationDao = locationDao;
        this.superheroDao = superheroDao;
    }

    @RequestMapping(value = "/topten", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> showSightings() {
        return sightingsDao.getTopTenSightings();
    }

    @RequestMapping(value = "/search/location", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> showSightingsByLocationAndDate(@QueryParam("location") String location, @QueryParam("date") String date) {

        List<Sighting> sightings;
        LocalDate searchDate = null;
        if (!StringUtils.isEmpty(date)) {
            searchDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        }
        if (StringUtils.isEmpty(location) && !StringUtils.isEmpty(date)) {
            sightings = sightingsDao.getByDate(searchDate);
        } else if (!StringUtils.isEmpty(location) && StringUtils.isEmpty(date)) {
            sightings = sightingsDao.getByLocation(Long.parseLong(location));
        } else {
            sightings = sightingsDao.getByLocationAndDate(Long.parseLong(location), searchDate);
        }
        return sightings;
    }

    @RequestMapping(value = "/search/superhero/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> showSightingsBySuperHero(@PathVariable("id") long id) {
        return sightingsDao.getBySuperHero(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> showAllSightings() {
        return sightingsDao.getAll();
    }

    @RequestMapping(value = "/sighting", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Sighting createSighting(@Valid @RequestBody SightingRequest sightingRequest) {
        Sighting sighting = new Sighting();
        sighting.setImage(sightingRequest.getImage());
        sighting.setDateSighted(LocalDate.parse(sightingRequest.getDateSighted(), DateTimeFormatter.ISO_DATE));

        long locationId = Long.parseLong(sightingRequest.getLocation());

        Location location = locationDao.getById(locationId);
        sighting.setLocation(location);

        Set<SuperHero> superheros = new HashSet<>();
        String[] tokens = sightingRequest.getSuperHeros().split(",");
        for (String token : tokens) {
            superheros.add(superheroDao.getById(Long.parseLong(token)));
        }
        sighting.setLocation(location);
        sighting.setSuperHero(superheros);

        return sightingsDao.add(sighting);
    }

    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.DELETE)
    public void deleteSighting(@PathVariable("id") long id) {
        sightingsDao.delete(id);
    }

}
