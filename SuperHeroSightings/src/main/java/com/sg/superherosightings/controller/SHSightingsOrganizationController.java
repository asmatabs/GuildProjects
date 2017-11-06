/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.SuperHero;
import com.sg.superherosightings.service.SHSightingsOrganizationService;
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
@RequestMapping({"/organizations"})
public class SHSightingsOrganizationController {

    SHSightingsOrganizationService organizationService;

    @Inject
    public SHSightingsOrganizationController(SHSightingsOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/orgs", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> showOrganizations() {
        return organizationService.retrieveAllOrganizations();
    }

    @RequestMapping(value = "/org/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization retrieveOrganizationById(@PathVariable("id") long id) {
        return organizationService.getOrganization(id);
    }

    @RequestMapping(value = "/addorg", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Organization createOrganization(@Valid @RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @RequestMapping(value = "/org/{id}", method = RequestMethod.DELETE)
    public void deleteOrganization(@PathVariable("id") long id) {
        organizationService.removeOrganization(id);
    }

}
