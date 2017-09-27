/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    void printn(String message)
    {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        printn(prompt);
        String input = scanner.nextLine();
        return Double.parseDouble(input);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
       
        do {
            printn(prompt);
            String input = scanner.nextLine();
            double d = Double.parseDouble(input);

            if (d <= min || d >= max) {
                System.out.println("Invalid input");
            } else {
                return d;
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt) {
        printn(prompt);
        return Float.parseFloat(scanner.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            printn(prompt);
            String input = scanner.nextLine();
            float f = Float.parseFloat(input);

            if (f <= min || f >= max) {
                System.out.println("Invalid input");
            } else {
                return f;
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt) {
        printn(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        do {
          
            printn(prompt);
            String input = scanner.nextLine();
            int i = Integer.parseInt(input);
            if (i < min || i > max) {
                System.out.println("Invalid input");
            } else {
                return i;
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        printn(prompt);
        return Long.parseLong(scanner.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            printn(prompt);
            String input = scanner.nextLine();
            long l = Long.parseLong(input);

            if (l <= min || l >= max) {
                System.out.println("Invalid input");
            } else {
                return l;
            }
        } while (true);
    }

    @Override
    public String readString(String prompt) {
        printn(prompt);
        return scanner.nextLine();

    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        printn(prompt);
        return new BigDecimal(scanner.nextLine());
    }
    
    
}
