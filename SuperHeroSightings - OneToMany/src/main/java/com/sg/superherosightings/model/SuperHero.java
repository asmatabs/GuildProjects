/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author asmat
 */
@Entity
public class SuperHero {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long superHeroId;
    private String superName;
    private String description;
    private String gender;
    
    @OneToMany(mappedBy ="superHeroId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<SuperHeroOrg> superHeroOrgs;

    @OneToMany(mappedBy ="superPowerHero", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<SuperHeroPowers> superHeroPowers;
    
    @OneToMany(mappedBy ="sightingSuperHero", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Sighting> sighting;
    
    public long getSuperHeroId() {
        return superHeroId;
    }

    public void setSuperHeroId(long superHeroId) {
        this.superHeroId = superHeroId;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<SuperHeroOrg> getSuperHeroOrgs() {
        if (superHeroOrgs == null)
        {
            superHeroOrgs = new HashSet<>();
        }
        return superHeroOrgs;
    }

    public void setSuperHeroOrgs(Set<SuperHeroOrg> superHeroOrgs) {
        this.superHeroOrgs = superHeroOrgs;
    }

    public Set<SuperHeroPowers> getSuperHeroPowers() {
        return superHeroPowers;
    }

    public void setSuperHeroPowers(Set<SuperHeroPowers> superHeroPowers) {
        this.superHeroPowers = superHeroPowers;
    }

    /*@Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.superHeroId ^ (this.superHeroId >>> 32));
        hash = 41 * hash + Objects.hashCode(this.superName);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.gender);
        hash = 41 * hash + Objects.hashCode(this.superHeroOrgs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuperHero other = (SuperHero) obj;
        if (this.superHeroId != other.superHeroId) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.superHeroOrgs, other.superHeroOrgs)) {
            return false;
        }
        return true;
    }*/

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.superHeroId ^ (this.superHeroId >>> 32));
        hash = 23 * hash + Objects.hashCode(this.superName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuperHero other = (SuperHero) obj;
        if (this.superHeroId != other.superHeroId) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        return true;
    }
}
