/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.SuperPower;
import com.sg.superherosightings.service.SHSightingsSuperPowerService;
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
@RequestMapping({"/superpowers"})
public class SHSightingsSuperPowerController {

    SHSightingsSuperPowerService superPowerService;

    @Inject
    public SHSightingsSuperPowerController(SHSightingsSuperPowerService superPowerService) {
        this.superPowerService = superPowerService;
    }

    @RequestMapping(value = "/powers", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperPower> retrievePowers() {
        return superPowerService.retrieveAllSuperPowers();
    }

    @RequestMapping(value = "/power/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SuperPower retrievePowerById(@PathVariable("id") long id) {
        return superPowerService.getSuperPower(id);
    }

    @RequestMapping(value = "/addpower", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SuperPower createSuperPower(@Valid @RequestBody SuperPower superPower) {
        return superPowerService.createSuperPower(superPower);
    }

    @RequestMapping(value = "/power/{id}", method = RequestMethod.DELETE)
    public void deleteSuperPower(@PathVariable("id") long id) throws Exception {
        superPowerService.removeSuperPower(id);
    }
}
