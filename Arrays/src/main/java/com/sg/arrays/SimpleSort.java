/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

import java.util.Arrays;

/**
 *
 * @author asmat
 */
public class SimpleSort {
     public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        // Sorting code should go here!
       // wholeNumbers = (int[])ArrayUtils.addAll(first, second);
       
       System.arraycopy(firstHalf, 0, wholeNumbers, 0, firstHalf.length);
       System.arraycopy(secondHalf, 0, wholeNumbers, firstHalf.length, secondHalf.length);
       
         System.out.println("Whole numbers looks like this --> " + Arrays.toString(wholeNumbers));
         
         //Sort
              
    }   
}
