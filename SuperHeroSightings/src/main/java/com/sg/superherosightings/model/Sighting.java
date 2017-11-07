/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author asmat
 */
@Entity
public class Sighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sightingId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId", insertable = true)
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SightingHero",
            joinColumns = @JoinColumn(name = "SightingId"),
            inverseJoinColumns = @JoinColumn(name = "SuperHeroId"))
    Set<SuperHero> superHero;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dateSighted;

    private String image;

    public Long getSightingId() {
        return sightingId;
    }

    public void setSightingId(Long sightingId) {
        this.sightingId = sightingId;
    }

    public Set<SuperHero> getSuperHero() {
        return superHero;
    }

    public void setSuperHero(Set<SuperHero> superHero) {
        this.superHero = superHero;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
