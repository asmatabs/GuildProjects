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
class Topping {
    private String[] nuts;
    private boolean chocolateShavings;

    /**
     * @return the nuts
     */
    public String[] getNuts() {
        return nuts;
    }

    /**
     * @param nuts the nuts to set
     */
    public void setNuts(String[] nuts) {
        this.nuts = nuts;
    }

    /**
     * @return the chocolateShavings
     */
    public boolean isChocolateShavings() {
        return chocolateShavings;
    }

    /**
     * @param chocolateShavings the chocolateShavings to set
     */
    public void setChocolateShavings(boolean chocolateShavings) {
        this.chocolateShavings = chocolateShavings;
    }
    
}
