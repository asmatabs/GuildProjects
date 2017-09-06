/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.enums;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class App {

    public enum DayOfTheWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Day of the Week: " + DayOfTheWeek.MONDAY);
        System.out.println("Enter a day of the week:");
        String day = sc.nextLine();
        int currentDay = 0;
        int friday = 5;
        int daysUntilFriday = 0;
        switch (day.toUpperCase()) {
            case "SUNDAY":
                currentDay = 0;
                break;
            case "MONDAY":
                currentDay = 1;
                break;
            case "TUESDAY":
                currentDay = 2;
                break;
            case "WEDNESDAY":
                currentDay = 3;
                break;
            case "THURSDAY":
                currentDay = 4;
                break;
            case "FRIDAY":
                currentDay = 5;
                break;
            case "SATURDAY":
                currentDay = -1;
                break;
        }
        
        while(currentDay++ < friday)
        {
         daysUntilFriday++;   
        }
        
        System.out.println("You have " + daysUntilFriday + " days until Friday!!");

    }
}
