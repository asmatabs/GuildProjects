/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hellow;

/**
 *
 * @author asmat
 */
public class Main {
    public static void main(String[] args) {
        String input = "1,\"Asma, Tabassum\",OH,200";
        System.out.println("Hello!");
       // input.chars().forEach(i -> System.out.println((char)i));
        
        String[] tokens = new String[4];
        
        tokens = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        
        for (String s:tokens)
        {
            System.out.println(s);
        

            
            
            
        }
    }
}
