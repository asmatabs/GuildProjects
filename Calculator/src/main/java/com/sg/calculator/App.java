/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.calculator;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculate calculate = new Calculate();
        boolean exit = false;
        do {

            
            System.out.println("1  -    Sum");
            System.out.println("2  -    Difference");
            System.out.println("3  -    Multiply");
            System.out.println("4  -    Divide");
            System.out.println("5  -    Modulus");
            System.out.println("0  -    Exit");
            System.out.print("Please select an option:");
            
            int option = sc.nextInt();

            System.out.print("Enter x:");
            String opr1 = sc.nextLine();

            System.out.print("Enter y:");
            int opr2 = sc.nextInt();
            int result = 0;
            switch (option) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    result = calculate.sum(opr1, opr2);
                    break;
                case 2:
                    result = calculate.diff(opr1, opr2);
                    break;
                case 3:
                    result = calculate.multiply(opr1, opr2);
                    break;
                case 4:
                    result = calculate.divide(opr1, opr2);
                    break;
                case 5:
                    result = calculate.modulus(opr1, opr2);
                    break;
            }
            
            System.out.println("Result of operation:" + result);

        } while (!exit);
    }
}
