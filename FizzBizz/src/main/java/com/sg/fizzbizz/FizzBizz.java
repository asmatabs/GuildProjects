/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fizzbizz;

/**
 *
 * @author asmat
 */
public class FizzBizz {
    public static void main(String[] args) {
        
        for (int i=0; i<=100 ; i++)
        {
            System.out.print("i: " + i + " ");
            if (i%3 ==0)
            {
                System.out.print("Fizz ");
            }
            if (i%5 ==0 )
            {
                System.out.print("Buzz ");
            }
            System.out.println("");

        }
    }
}
