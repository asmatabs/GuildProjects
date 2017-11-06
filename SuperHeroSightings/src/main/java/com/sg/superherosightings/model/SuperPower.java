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

 }
