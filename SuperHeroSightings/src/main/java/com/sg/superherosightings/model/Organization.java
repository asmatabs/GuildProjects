    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author asmat
 */
@Entity
public class Organization {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long orgId;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId", insertable = true, updatable = true, nullable = false)
    private Address address;

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
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

//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 29 * hash + Objects.hashCode(this.orgId);
//        hash = 29 * hash + Objects.hashCode(this.name);
//        hash = 29 * hash + Objects.hashCode(this.description);
//        hash = 29 * hash + Objects.hashCode(this.superHeroOrgs);
//        hash = 29 * hash + Objects.hashCode(this.address);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Organization other = (Organization) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        if (!Objects.equals(this.orgId, other.orgId)) {
//            return false;
//        }
//        if (!Objects.equals(this.superHeroOrgs, other.superHeroOrgs)) {
//            return false;
//        }
//        if (!Objects.equals(this.address, other.address)) {
//            return false;
//        }
//        return true;
//    }




}
