/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.functionalunittests;

/**
 *
 * @author asmat
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 2, 3, 3};

        Main main = new Main();

        boolean commonEnd = main.commonEnd(a, b);
        System.out.println(commonEnd);
    }

    // Given 2 arrays of ints, a and b, return true if they 
    // have the same first element or they have the same 
    // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
    public boolean commonEnd(int[] a, int[] b) {
        if (a[0] == b[0] || (a[a.length - 1] == b[b.length - 1])) {
            return true;
        }
        return false;
    }

    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        int i = str.indexOf('x');
        if (str.charAt(i + 1) == 'x') {

            return true;
        }
        return false;
    }

    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    public int caughtSpeeding(int speed, boolean isBirthday) {

        int ticketType = 0;
        int speedLimit = 60;
        int maxSpeedLimit = 80;
        if (speed > speedLimit) {
            if (isBirthday) {
                speedLimit += 5;
                maxSpeedLimit += 5;

            }
            if (speed > speedLimit && speed <= maxSpeedLimit) {
                ticketType = 1;
            }
            if (speed > maxSpeedLimit) {
                ticketType = 2;
            }
        }
        return ticketType;
    }
}
