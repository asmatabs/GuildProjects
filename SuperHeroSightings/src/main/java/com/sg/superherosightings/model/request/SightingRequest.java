/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model.request;

/**
 *
 * @author asmat
 */
public class SightingRequest {

    private String location;
    private String superHeros;
    private String dateSighted;
    private String image;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSuperHeros() {
        return superHeros;
    }

    public void setSuperHeros(String superHeros) {
        this.superHeros = superHeros;
    }

    public String getDateSighted() {
        return dateSighted;
    }

    public void setDateSighted(String dateSighted) {
        this.dateSighted = dateSighted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
