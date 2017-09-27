/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sectionthreeunittests;

/**
 *
 * @author asmat
 */
public class StringTimes {
    // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"

    public String stringTimes(String str, int n) {
        String out = "";
        while(n-- >= 1)
        {
            out = out.concat(str);
        }
        return out;
    }

}
