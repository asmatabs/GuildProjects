/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.eveninfibonacciseq;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asmat
 */
public class Main {
    
    
    
    public static void main(String[] args) {

        List<Integer> fibonacciList = new ArrayList<>();
        
        int first = 0, second = 1;
        fibonacciList.add(first);
        fibonacciList.add(second);
        int next = 0, i = 1, sum =0, primeSum = 0;
        do
        {
             next = fibonacciList.get(i-1) + fibonacciList.get(i);
             fibonacciList.add(next);
             if (next%2 == 0)
             {
                 sum += next;
             }
             
             //check if prime
             boolean notPrime = false;
             for(int x=2; x<next ;x++)
             {
                 
                 if (next%x == 0)
                 {
                     notPrime = true;
                 }
             }
             
             if (!notPrime && next!= 1)
             {
                 primeSum += next;
                         
             }
            i++;
        }while(next <= 4000000);
        System.out.println(fibonacciList);
        System.out.println("Sum of Even numbers in series:" + sum);
        System.out.println("Sum of Prime numbers: " + primeSum);
    }
}
