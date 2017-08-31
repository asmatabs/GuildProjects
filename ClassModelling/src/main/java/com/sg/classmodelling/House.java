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
public class House {
    
    private String color;
    private Address address;
    private int plotLength;
    private int plotWidth;
    private String facing;
    
    private String latitude;
    private String longitude;

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the plotLength
     */
    public int getPlotLength() {
        return plotLength;
    }

    /**
     * @param plotLength the plotLength to set
     */
    public void setPlotLength(int plotLength) {
        this.plotLength = plotLength;
    }

    /**
     * @return the plotWidth
     */
    public int getPlotWidth() {
        return plotWidth;
    }

    /**
     * @param plotWidth the plotWidth to set
     */
    public void setPlotWidth(int plotWidth) {
        this.plotWidth = plotWidth;
    }

    /**
     * @return the facing
     */
    public String getFacing() {
        return facing;
    }

    /**
     * @param facing the facing to set
     */
    public void setFacing(String facing) {
        this.facing = facing;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
