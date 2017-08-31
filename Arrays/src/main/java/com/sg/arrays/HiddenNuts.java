/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

import java.util.Random;

/**
 *
 * @author asmat
 */
public class HiddenNuts {
    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        int rand = squirrel.nextInt(hidingSpots.length);
        System.out.println("Random number is " + rand);
        hidingSpots[rand] = "Nut";
        System.out.println("The nut has been hidden ...");

		// Nut finding code should go here! 
        for(int i=0; i<hidingSpots.length; i++)
        {
            if(hidingSpots[i] !=null && hidingSpots[i].compareTo("Nut") == 0)
            {
                System.out.println("Found the nut at " + i);
            }
        }
    }
}
