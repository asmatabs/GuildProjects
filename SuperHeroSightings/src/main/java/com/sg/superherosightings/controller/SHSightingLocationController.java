/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SHSightingsAddressDao;
import com.sg.superherosightings.dao.SHSightingsLocationDao;
import com.sg.superherosightings.dao.SHSightingsSightingDao;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.request.LocationRequest;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
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
@RequestMapping({"/locations"})
public class SHSightingLocationController {

    SHSightingsLocationDao locationDao;
    SHSightingsAddressDao addressDao;
    SHSightingsSightingDao sightingDao;

    @Inject
    public SHSightingLocationController(SHSightingsLocationDao locationDao, SHSightingsAddressDao addressDao,SHSightingsSightingDao sightingDao) {
        this.locationDao = locationDao;
        this.addressDao = addressDao;
        this.sightingDao = sightingDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> showLocations() {
        return locationDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Location getLocation(@PathVariable long id) {
        return locationDao.getById(id);
    }

    @RequestMapping(value = "/location", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location saveLocation(@Valid @RequestBody LocationRequest locationReq) {

        Location location;
        Address address;
        if (locationReq.getLocationId() == 0) {
            location = new Location();
            address = new Address();
        } else {
            location = locationDao.getById(locationReq.getLocationId());
            address = location.getAddress();
        }

        location.setName(locationReq.getName());
        location.setDescription(locationReq.getDescription());

        address.setStreet(locationReq.getStreet());
        address.setCity(locationReq.getCity());
        address.setCountry(locationReq.getCountry());
        address.setState(locationReq.getState());
        address.setPostalCode(locationReq.getPostalCode());
        if (!StringUtils.isEmpty(locationReq.getLatitude())) {
            address.setLatitude(Float.parseFloat(locationReq.getLatitude()));
        }
        if (!StringUtils.isEmpty(locationReq.getLongitude())) {
            address.setLongitude(Float.parseFloat(locationReq.getLongitude()));
        }

        location.setAddress(address);

        if (locationReq.getLocationId() == 0) {
            return locationDao.add(location);
        } else {
            location.setLocationId(locationReq.getLocationId());
            addressDao.update(address);
            return locationDao.update(location);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable("id") long id) {
        sightingDao.deleteByLocation(id);
        locationDao.delete(id);
    }
}
