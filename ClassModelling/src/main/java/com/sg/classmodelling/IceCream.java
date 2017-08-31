/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classmodelling;

/**
 *
 * @author asmat
 */
public class IceCream {
    private String name;
    private String brand;
    private float price;
    private int numberOfServings;
    private String description;
    private Topping toppings;

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
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the numberOfServings
     */
    public int getNumberOfServings() {
        return numberOfServings;
    }

    /**
     * @param numberOfServings the numberOfServings to set
     */
    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the toppings
     */
    public Topping getToppings() {
        return toppings;
    }

    /**
     * @param toppings the toppings to set
     */
    public void setToppings(Topping toppings) {
        this.toppings = toppings;
    }
    
    
}
