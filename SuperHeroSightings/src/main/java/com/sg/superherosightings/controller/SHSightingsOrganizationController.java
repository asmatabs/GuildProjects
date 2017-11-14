/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SHSightingsAddressDao;
import com.sg.superherosightings.dao.SHSightingsOrganizationDao;
import com.sg.superherosightings.model.Address;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.request.OrganizationReq;
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

    SHSightingsOrganizationDao organizationDao;
    SHSightingsAddressDao addressDao;

    @Inject
    public SHSightingsOrganizationController(SHSightingsOrganizationDao organizationDao, SHSightingsAddressDao addressDao) {
        this.organizationDao = organizationDao;
        this.addressDao = addressDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> showOrganizations() {
        return organizationDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization retrieveOrganizationById(@PathVariable("id") long id) {
        return organizationDao.getById(id);
    }

    @RequestMapping(value = "/org", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Organization saveOrganization(@Valid @RequestBody OrganizationReq orgReq) {

        Organization org;
        Address address;
        if (orgReq.getOrgId() == 0) {
            org = new Organization();
            address = new Address();
        } else {
            org = organizationDao.getById(orgReq.getOrgId());
            address = org.getAddress();
        }

        org.setName(orgReq.getName());
        org.setDescription(orgReq.getDescription());

        address.setStreet(orgReq.getStreet());
        address.setCity(orgReq.getCity());
        address.setCountry(orgReq.getCountry());
        address.setState(orgReq.getState());
        address.setPostalCode(orgReq.getPostalCode());

        org.setAddress(address);

        if (orgReq.getOrgId() == 0) {
            return organizationDao.add(org);
        } else {
            org.setOrgId(orgReq.getOrgId());
            addressDao.update(address);
            return organizationDao.update(org);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrganization(@PathVariable("id") long id) {
        organizationDao.deleteSuperHeroOrgs(id);
        organizationDao.delete(id);
    }

}
