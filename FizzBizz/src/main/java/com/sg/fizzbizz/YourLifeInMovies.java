/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fizzbizz;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class YourLifeInMovies {
    public static void main(String[] args) {
        
        int yearOfBirth;
        Scanner myReader = new Scanner(System.in);
        
        System.out.println("What's year were you born in?");
        yearOfBirth = myReader.nextInt();
        
        if(yearOfBirth < 2005)
        {
            System.out.println("Pixar's 'Up' came out half a decade ago!!");
        }
        if(yearOfBirth < 1995)
        {
            System.out.println("The first Harry Potter came out over 15 years ago!!");
        }
        if(yearOfBirth < 1985)
        {
            System.out.println("Space Jam came out not last decade, but the one before THAT!!");
        }
        if(yearOfBirth < 1975)
        {
            System.out.println("The original Jurassic Park release is closer to the lunar landing, than today!!");
        }
        if(yearOfBirth < 1965)
        {
            System.out.println("The MASH has been around for almost half a century!");
        }
        
    }
   
}
