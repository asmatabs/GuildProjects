/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SHSightingsLocationDao;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.request.LocationRequest;
import java.util.List;
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
@RequestMapping({"/locations"})
public class SHSightingLocationController {

    SHSightingsLocationDao locationDao;

    @Inject
    public SHSightingLocationController(SHSightingsLocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> showLocations() {
        return locationDao.getAll();
    }

    @RequestMapping(value = "/location", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location createLocation(@Valid @RequestBody LocationRequest locationReq) {
        Location location = new Location();
        location.setName(locationReq.getName());
        location.setDescription(locationReq.getDescription());
        
        Address address = new Address();
        address.setStreet(locationReq.getStreet());
        address.setCity(locationReq.getCity());
        address.setCountry(locationReq.getCountry());
        address.setState(locationReq.getState());
        address.setPostalCode(locationReq.getPostalCode());
        address.setLatitude(Float.parseFloat(locationReq.getLatitude()));
        address.setLongitude(Float.parseFloat(locationReq.getLongitude()));
        
        location.setAddress(address);
        return locationDao.add(location);
    }

    @RequestMapping(value = "/location", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable("id") long id) {
        locationDao.delete(id);
    }
}
