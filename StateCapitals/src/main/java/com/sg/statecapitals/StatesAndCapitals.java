/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author asmat
 */
public class StatesAndCapitals {
 
    public static void main(String[] args) {
        
        HashMap<String, String> capitals = new HashMap<>(); 
        capitals.put("Alabama" , "Montgomery");
        capitals.put("Alaska" , "Juneau");
        capitals.put("Arizona" , "Phoenix");
        capitals.put("Arkansas" , "Little Rock");
        
        System.out.println("Capital of Alabama: " + capitals.get("Alabama"));
        
        //Get all the keys form the map
        Set<String> keys = capitals.keySet();
        
        //print keys alone
        System.out.println(capitals.keySet());
        
        Collection<String> capitalCities = capitals.values();
        System.out.println(capitalCities);
        
        //print keys-value
        System.out.println("STATE       -     CAPITALS");
        System.out.println("===========================");
        
        for (String s:keys)
        {
            System.out.println(s + "            " + capitals.get(s));
        }
        
        
        
    }
}
