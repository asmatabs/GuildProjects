/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fizzbizz;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class FieldDay {
    public static void main(String[] args) {
        
        Scanner myReader = new Scanner(System.in);
        System.out.println("What's your last name?");
        String lastName = myReader.nextLine();
        
        if(lastName.compareToIgnoreCase("Baggins") < 0)
        {
            System.out.println("You are on team Red Dragons");
        }
        else if(lastName.compareToIgnoreCase("Dresden") < 0)
        {
            System.out.println("You are on team Dark Wizards");
        }
        else if(lastName.compareToIgnoreCase("Howl") < 0)
        {
            System.out.println("You are on team Moving Castles");
        }
        else if(lastName.compareToIgnoreCase("Potter") < 0)
        {
            System.out.println("You are on team Golden Snitches");
        }
        else if(lastName.compareToIgnoreCase("Vimes") < 0)
        {
            System.out.println("You are on team Night Guards");
        }
        else
        {
            System.out.println("You are on team Black Holes");
        }
        System.out.println("Good luck in the games");
    }
}
