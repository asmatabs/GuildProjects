/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author asmat
 */
public class StatesAndCapitals2 {
    public static void main(String[] args) {
        
        //UserIO io = new UserIOImpl();
        Scanner sc = new Scanner(System.in);
        Capital capAlabama = new Capital("Montgomery", 205000, "156 sq mi");
        Capital capAlaska = new Capital("Juneau", 31000 , "3255 sq mi");
        Capital capArizona = new Capital("Phoenix", 1445000  , "517 sq mi");
        
        HashMap<String, Capital> capitals = new HashMap<>(); 
        capitals.put("Alabama" , capAlabama);
        capitals.put("Alaska" , capAlaska);
        capitals.put("Arizona" , capArizona);
        
        //Get all the keys form the map
        Set<String> keys = capitals.keySet();
        
        //print keys alone
        System.out.println(capitals.keySet());
        
        System.out.print("Enter a lower limit for the population: ");
        long num = sc.nextInt();
        
        //print keys-value
        System.out.println("STATE       -     CAPITALS");
        System.out.println("===========================");
        
        for (String s:keys)
        {
            if(capitals.get(s).getPopulation() >= num)
            System.out.println(s + "            " + capitals.get(s).getName() +"|"+ capitals.get(s).getPopulation()+"|"+capitals.get(s).getSqMileage());
        }
        
        
        
    }

}
