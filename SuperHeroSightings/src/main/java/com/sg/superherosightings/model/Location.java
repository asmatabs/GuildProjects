/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author asmat
 */
@Entity
public class Location {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long locationId;
    private String name;
    private String description;
    
    //@OneToOne (mappedBy = "addressId", fetch = FetchType.EAGER, orphanRemoval = false)
    //@JoinColumn(name = "AddressId", referencedColumnName = "AddressId", insertable = true, updatable = true, nullable = false)
    
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId", insertable = true)
    @OneToOne
    @JoinColumn(name = "AddressId")
    private Address address;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
