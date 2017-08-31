/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.methods;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class LuckySeven {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many dollars do you have?");
        int amount;
        do
        {
            amount = sc.nextInt();
            if(amount <=0 )
            {
                System.out.println("Please enter a valid number");
            }
        }while (amount < 0 );
        
        int rolls = 0, breakingRoll = 0, highestAmount = amount;
        do
        {
            //Roll the dice until money is gone
            int firstDice = rollTheDice();
            int secondDice = rollTheDice();
   
            if (firstDice + secondDice == 7)
            {
                amount += 4;
            }
            else
            {
                amount--;
            }
            rolls++;
            if (amount > highestAmount)
            {
                highestAmount = amount;
                breakingRoll = rolls;
            }
              
        }while(amount >= 0);
        
        System.out.println("You broke after " + rolls + " rolls");
        System.out.println("You should have quit after " + breakingRoll + " when you had " + highestAmount);
    }
    
    public static int rollTheDice()
    {
        Random randomizer = new Random();
        return(randomizer.nextInt(7) + 1);
    }
}
