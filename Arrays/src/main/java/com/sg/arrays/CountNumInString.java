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
public class CountNumInString {
    public static void main(String[] args) {
        String strOfNumbers = "54300012";
        
        int[] counts;
        
        counts = findCountOfNumbers(strOfNumbers);
        
        System.out.println("Array of counts prints ... " + Arrays.toString(counts));
        
    }
    
    public static int[] findCountOfNumbers(String strOfNumbers)
    {

        int[] output = new int[10];
        
        for(int i = 0; i < strOfNumbers.length(); i++)
        {
            int num = strOfNumbers.charAt(i)-48;
            output[num]++;
                    
        }
        return output;
        
    }
}
