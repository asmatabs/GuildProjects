/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fizzbizz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class GuessMe {
    public static void main(String[] args) {
        
        Random randomizer = new Random(); 
        int number = randomizer.nextInt(200) - 100;
        
        System.out.println("I have a number between -100 and 100, bet you can't guess it!");
        int attemptCount = 0;
        do
        {
            System.out.println("Whats your guess?");
        
            Scanner myReader = new Scanner(System.in);
            int guess = myReader.nextInt();

            if (guess == number)
            {
                System.out.println("Wow, nice guess! That was it");
            }
            else if( guess < number)
            {
                System.out.println("Ha nice try! Too low.. ");
            }
            else
            {
                System.out.println("Ha nice try! Too high..");
            }
            attemptCount++;
            
            if(attemptCount<2)
            {
                System.out.println("Try again..");
            }
        }while(attemptCount < 2);
        
        System.out.println("Number generated: " + number);
    }
}
