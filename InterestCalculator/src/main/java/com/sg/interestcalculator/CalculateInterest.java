/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class CalculateInterest {
    
    public static void main(String[] args) {
        
        float interestRate;
        float principalAmount;
        int years;
        int repeatPeriod = 0;
        Scanner sc = new Scanner(System.in);
        boolean repeat;
        do{
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
            
            if(interestRate < 0 || principalAmount<0 || years< 0)
            {
                System.out.println("Please enter a valid data.. try again!");
                repeat = true;
            }
            
            
        }while(repeat);

        float amountFromInterest = 0, prinicipalAtEndOfYear = principalAmount;
        float totalInterestAmount =0;
        
        switch(repeatPeriod)
        {
            case 1: repeatPeriod = 365;
                    break;
            case 2: repeatPeriod = 12;
                    break;
            case 3: repeatPeriod = 4;
                    break;
            default: repeatPeriod = 1; //calculate annually if error      
        }
        
        interestRate = interestRate / repeatPeriod;
        
        //Loop for every year
        for (int i=0; i<years; i++)
        {
            System.out.println("Year " + (i+1) + "-----> ");
            System.out.println("Principle amount ........................... " + principalAmount);
            
            for (int j = 0; j < repeatPeriod; j++)
            {
                float newPrincipalAmount = principalAmount * (1+ interestRate/100);
                amountFromInterest = newPrincipalAmount - principalAmount;
                
                totalInterestAmount += amountFromInterest;
                principalAmount = newPrincipalAmount;
            }

            System.out.println("Amount earned from interest alone ..........." + totalInterestAmount);
            System.out.println("Principle amount at the end of this year....." + principalAmount);
            
        }
    }
}
