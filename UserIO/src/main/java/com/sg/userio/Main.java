/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

/**
 *
 * @author asmat
 */
public class Main {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        
        io.print("Testing my interface");
        
        double d = io.readDouble("Enter a double");
        System.out.println(d);
        
        d = io.readDouble("Enter a double", 1, 10);
        System.out.println(d); 
        
        float f = io.readFloat("Enter a double (1-99.99)", 1, (float)99.99);
        System.out.println(f);
    }
}
