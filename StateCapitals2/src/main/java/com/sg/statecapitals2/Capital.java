/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

/**
 *
 * @author asmat
 */
public class Capital {
    private String name;
    private long population;
    private String sqMileage;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * @return the sqMileage
     */
    public String getSqMileage() {
        return sqMileage;
    }

    /**
     * @param sqMileage the sqMileage to set
     */
    public void setSqMileage(String sqMileage) {
        this.sqMileage = sqMileage;
    }

    public Capital(String name, long population, String sqMileage) {
        this.name = name;
        this.population = population;
        this.sqMileage = sqMileage;
    }
}
