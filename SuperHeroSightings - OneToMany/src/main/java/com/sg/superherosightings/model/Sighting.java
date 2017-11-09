/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author asmat
 */
@Entity
public class Sighting {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long sightingId;
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "SuperHeroId", referencedColumnName = "SuperHeroId", insertable = true)
    private SuperHero sightingSuperHero;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "LocationId", referencedColumnName = "LocationId", insertable = true)
    private Location location;
    
    private LocalDate dateSighted; 

    public Long getSightingId() {
        return sightingId;
    }

    public void setSightingId(Long sightingId) {
        this.sightingId = sightingId;
    }

    public SuperHero getSightingSuperHero() {
        return sightingSuperHero;
    }

    public void setSightingSuperHero(SuperHero sightingSuperHero) {
        this.sightingSuperHero = sightingSuperHero;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getDateSighted() {
        return dateSighted;
    }

    public void setDateSighted(LocalDate dateSighted) {
        this.dateSighted = dateSighted;
    }
    
}
