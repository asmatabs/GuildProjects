/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author asmat
 */
@Entity
public class SuperPower {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long superPowerId;
    private String power;
    private String description;

    @OneToMany(mappedBy ="superPower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<SuperHeroPowers> superHeroPowers;
        
    public long getSuperPowerId() {
        return superPowerId;
    }

    public void setSuperPowerId(long superPowerId) {
        this.superPowerId = superPowerId;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SuperHeroPowers> getSuperHeroPowers() {
        return superHeroPowers;
    }

    public void setSuperHeroPowers(Set<SuperHeroPowers> superHeroPowers) {
        this.superHeroPowers = superHeroPowers;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 29 * hash + (int) (this.superPowerId ^ (this.superPowerId >>> 32));
//        hash = 29 * hash + Objects.hashCode(this.power);
//        hash = 29 * hash + Objects.hashCode(this.description);
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
//        final SuperPower other = (SuperPower) obj;
//        if (this.superPowerId != other.superPowerId) {
//            return false;
//        }
//        if (!Objects.equals(this.power, other.power)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        return true;
//    }
 }
