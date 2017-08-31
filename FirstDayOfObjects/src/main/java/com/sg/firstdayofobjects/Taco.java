/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.firstdayofobjects;

/**
 *
 * @author asmat
 */
public class Taco {
   private String name;
   private TacoShell tacoShell;

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
     * @return the tacoShell
     */
    public TacoShell getTacoShell() {
        return tacoShell;
    }

    /**
     * @param tacoShell the tacoShell to set
     */
    public void setTacoShell(TacoShell tacoShell) {
        this.tacoShell = tacoShell;
    }
}
