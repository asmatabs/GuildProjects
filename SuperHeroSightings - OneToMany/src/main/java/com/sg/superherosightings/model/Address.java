/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author asmat
 */
@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long addressId;
    private String Street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private Float latitude;
    private Float longitude;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 73 * hash + (int) (this.addressId ^ (this.addressId >>> 32));
//        hash = 73 * hash + Objects.hashCode(this.Street);
//        hash = 73 * hash + Objects.hashCode(this.city);
//        hash = 73 * hash + Objects.hashCode(this.state);
//        hash = 73 * hash + Objects.hashCode(this.country);
//        hash = 73 * hash + Objects.hashCode(this.postalCode);
//        hash = 73 * hash + (this.latitude == null? 0 : Float.floatToIntBits(this.latitude));
//        hash = 73 * hash + (this.longitude == null? 0 : Float.floatToIntBits(this.longitude));
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
//        final Address other = (Address) obj;
//        if (this.addressId != other.addressId) {
//            return false;
//        }
//        if (this.latitude != null && Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
//            return false;
//        }
//        if (this.longitude != null && Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
//            return false;
//        }
//        if (!Objects.equals(this.Street, other.Street)) {
//            return false;
//        }
//        if (!Objects.equals(this.city, other.city)) {
//            return false;
//        }
//        if (!Objects.equals(this.state, other.state)) {
//            return false;
//        }
//        if (!Objects.equals(this.country, other.country)) {
//            return false;
//        }
//        if (!Objects.equals(this.postalCode, other.postalCode)) {
//            return false;
//        }
//        return true;
//    }
}
