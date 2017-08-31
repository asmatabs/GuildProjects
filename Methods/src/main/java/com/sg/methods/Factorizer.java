/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.methods;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class Factorizer {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        do
        {
            System.out.println("Please enter a valid positive number:");
            num = sc.nextInt();
        }while (num <= 0);

        System.out.println("The number you entered is: " + num);

        int countOfFactors = 1, sumOfFactors = 1;

        
//        for(int i = num/2; i > 2 ; i--)
//        {
//            if (num%i == 0)
//            {
//                System.out.println(i + " is a factor");
//                countOfFactors++;
//                sumOfFactors += i;
//            }
//        }
//        if( num%2 == 0)
//        {
//            System.out.println("2 is a factor");
//            countOfFactors++;
//            sumOfFactors += 2;
//        }
        
        

        System.out.println("1 is a factor");
        System.out.println("The total number of factors is : " + countOfFactors);
        if (sumOfFactors == num)
        {
            System.out.println("It is a perfect number ");
        }
        
        if(countOfFactors == 1)
        {
            System.out.println("It is a prime number");
        }
    }
}
