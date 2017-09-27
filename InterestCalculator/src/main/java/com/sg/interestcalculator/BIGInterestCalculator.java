/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class BIGInterestCalculator {
    
    public static void main(String[] args) {
        
        BigDecimal interestRate = new BigDecimal(0);
        BigDecimal principalAmount = new BigDecimal(0);
        int years;
        int repeatPeriod = 0;
        Scanner sc = new Scanner(System.in);
        boolean repeat;
        do{
            repeat = false;
            System.out.println("Annual Interest Rate:");
            interestRate = sc.nextBigDecimal();

            System.out.println("Principal Amount: ");
            principalAmount = sc.nextBigDecimal();
            
            System.out.println("How manys years do you want the money to stay in the fund?");
            years = sc.nextInt();
            
            System.out.println("Select the compound interval: ");
            System.out.println("1. Daily");
            System.out.println("2. Monthly");
            System.out.println("3. Quarterly");
            repeatPeriod = sc.nextInt();
            
            if(interestRate.intValue() < 0 || principalAmount.intValue() <0 || years < 0)
            {
                System.out.println("Please enter a valid data.. try again!");
                repeat = true;
            }
            
            
        }while(repeat);

        //BigDecimal amountFromInterest = new BigDecimal(0);
        BigDecimal prinicipalAtEndOfYear = new BigDecimal(0);
        BigDecimal totalInterestAmount = new BigDecimal(0);
        
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
        BigDecimal repeatPeriodBig = new BigDecimal(repeatPeriod);
        interestRate = interestRate.divide(repeatPeriodBig);
        
        //Loop for every year
        for (int i=0; i<years; i++)
        {
            System.out.println("Year " + (i+1) + "-----> ");
            System.out.println("Principle amount ........................... " + principalAmount);
            
            for (int j = 0; j < repeatPeriod; j++)
            {
                BigDecimal x = interestRate.divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
                BigDecimal newPrincipalAmount = principalAmount.multiply(x);
                BigDecimal amountFromInterest = newPrincipalAmount.subtract((principalAmount));
                
                totalInterestAmount = totalInterestAmount.add(amountFromInterest);
                principalAmount = newPrincipalAmount;
            }

            System.out.println("Amount earned from interest alone ..........." + totalInterestAmount);
            System.out.println("Principle amount at the end of this year....." + principalAmount);
            
        }
    }
}
