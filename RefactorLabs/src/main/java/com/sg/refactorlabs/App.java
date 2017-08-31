/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.refactorlabs;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class App {

    public static void main(String[] args) {
        
        InterestCalculator();
        
    }
    
    public static void InterestCalculator()
    {
        Scanner sc = new Scanner(System.in);
        float interestRate;
        float principalAmount;
        int years;
        int repeatPeriod = 0;

        boolean repeat;
        do {
            repeat = false;
            System.out.println("Annual Interest Rate:");
            interestRate = sc.nextFloat();

            System.out.println("Principal Amount: ");
            principalAmount = sc.nextFloat();

            System.out.println("How manys years do you want the money to stay in the fund?");
            years = sc.nextInt();

            System.out.println("Select the compound interval: ");
            System.out.println("1. Daily");
            System.out.println("2. Monthly");
            System.out.println("3. Quarterly");
            repeatPeriod = sc.nextInt();

            if (interestRate < 0 || principalAmount < 0 || years < 0) {
                System.out.println("Please enter valid data.. try again!");
                repeat = true;
            }

        } while (repeat);

        CalculateInterest calcInterest = new CalculateInterest(principalAmount, interestRate, years, repeatPeriod);
        calcInterest.showInterest();
    }
}
