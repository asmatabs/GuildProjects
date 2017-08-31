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
public class FruitsBasket {
        public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};

        // Fruit sorting code goes here!
        String[] apples;
        String[] oranges;
        int appleCount=0, orangeCount=0;
        for( int i = 0; i < fruit.length; i++)
        {
            if(fruit[i].compareTo("Apple") == 0)
            {
             //   apples[appleCount++] = "Apple";
                appleCount++;
            }
            else if(fruit[i].compareTo("Orange") == 0)
            {
             //   oranges[orangeCount++] = "Orange";
                orangeCount++;
            }
        }
        
        apples = new String[appleCount];
        oranges = new String[orangeCount];
        
        for (int i=0;i<appleCount;i++)
        {
            apples[i] = "Apple";
        }
        for (int i=0;i<orangeCount;i++)
        {
            oranges[i] = "Oranges";
        }
        
        System.out.println("There are " +fruit.length + " fruits in total");
        System.out.println("Out of which " + appleCount + " are apples");
        System.out.println("And " + orangeCount + " are oranges");
        System.out.println("Output of apple array " + Arrays.toString(apples));
        System.out.println("Output of orange array " + Arrays.toString(oranges));
    }
}
