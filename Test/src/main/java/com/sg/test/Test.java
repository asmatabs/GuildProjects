/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

/**
 *
 * @author asmat
 */
public class Test {
    public static void main(String[] args) {
        double totalMemory = 2048298;
        double usedMemory = 24345;
        
        double percentage = (usedMemory/totalMemory)*100;
        
        System.out.printf("percentage:" + percentage);
        int x = (int)percentage;
        System.out.println(x);
    }
}
