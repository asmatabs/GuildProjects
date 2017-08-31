/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.methods;

import java.util.Random;

/**
 *
 * @author asmat
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = randomColor(); // call color method here 
        String animal = randomAnimal(); // call animal method again here 
        String colorAgain = randomColor(); // call color method again here 
        int weight = getRandomNumber(5, 200); // call number method, 
            // with a range between 5 - 200 
        int distance = getRandomNumber(10, 20); // call number method, 
            // with a range between 10 - 20 
        int number = getRandomNumber(10000, 20000); // call number method, 
            // with a range between 10000 - 20000 
        int time = getRandomNumber(2, 6); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + " lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public static String randomColor()
    {
        String color;
        Random randomizer = new Random();
        int x = randomizer.nextInt(5);
        
        switch(x){
            case 0: color = "Yellow";
                    break;
            case 1: color = "Red";
                    break;
            case 2: color = "Blue";
                    break;
            case 3: color = "Green";
                    break;
            case 4: color = "Pink";
                    break;
            default : color = "Black";               
        }
        return color;
    }
    
    // ??? Method 1 ??? 
    // ??? Method 2 ??? 
    public static String randomAnimal()
    {
        String color;
        Random randomizer = new Random();
        int x = randomizer.nextInt(5);
        
        switch(x){
            case 0: color = "Tiger";
                    break;
            case 1: color = "Elephant";
                    break;
            case 2: color = "Dog";
                    break;
            case 3: color = "Cat";
                    break;
            case 4: color = "Zebra";
                    break;
            default : color = "Monkey";               
        }
        return color;
    }    
    // ??? Method 3 ??? 
    public static int getRandomNumber(int minRange, int maxRange)
    {
        Random randomizer = new Random();
        int rand = (randomizer.nextInt(maxRange - minRange) + 1) + minRange;      
        return rand;
    }
}
