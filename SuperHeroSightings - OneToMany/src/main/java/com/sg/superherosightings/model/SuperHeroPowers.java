/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Objects;
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
public class SuperHeroPowers {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long superHeroPowersId;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "SuperHeroId", referencedColumnName = "SuperHeroId", insertable = true)
    private SuperHero superPowerHero;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "SuperPowerId", referencedColumnName = "SuperPowerId", insertable = true)
    private SuperPower superPower;

    public Long getSuperHeroPowersId() {
        return superHeroPowersId;
    }

    public void setSuperHeroPowersId(Long superHeroPowersId) {
        this.superHeroPowersId = superHeroPowersId;
    }

    public SuperHero getSuperPowerHero() {
        return superPowerHero;
    }

    public void setSuperPowerHero(SuperHero superPowerHero) {
        this.superPowerHero = superPowerHero;
    }

    public SuperPower getSuperPower() {
        return superPower;
    }

    public void setSuperPower(SuperPower superPower) {
        this.superPower = superPower;
    }


}
