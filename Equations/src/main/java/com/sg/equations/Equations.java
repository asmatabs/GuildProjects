/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.equations;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author asmat
 */
public class Equations {

    public static void main(String[] args) {

        String[] arg1 = {"2","2","+"};
        String[] arg2 = {"6","3","/", "3", "+"};
        String[] arg3 = {"2","+","2"};
        String[] arg4 = {"2","2","2", "2", "+", "*", "*"};
        String[] arg5 = {"12", "10", "*", "2", "*", "60", "/"};
        //String arg5 = "12";
       
        System.out.println("2 2 + = " + evaluate(arg1));
        System.out.println("6 3 / 3 + = " + evaluate(arg2));
        System.out.println("2 + 2 = " + evaluate(arg3));
        System.out.println("2 2 2 2 + * * = " + evaluate(arg4));
        System.out.println("12 10 * 2 * 60 / = " + evaluate(arg5));

    }

    public static int evaluate(String[] eq) {
        int operand1 = 0, operand2 = 0, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < eq.length; i++) {
            int operand;
            switch (eq[i]) {
                case "+":
                    try {
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("Invalid operation");
                        return 0;
                    }

                    result = operand1 + operand2;
                    stack.push(result);
                    break;
                case "-":
                    try {
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("Invalid operation");
                        return 0;
                    }
                    result = operand2 - operand1;
                    stack.push(result);
                    break;
                case "*":
                    try {
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("Invalid operation");
                        return 0;
                    }
                    result = operand1 * operand2;

                    stack.push(result);
                    break;
                case "/":
                    try {
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                    } catch (EmptyStackException e) {
                        System.out.println("Invalid operation");
                        return 0;
                    }
                    result = operand2 / operand1;
                    stack.push(result);
                    break;
                default:
                    int a = Integer.parseInt(eq[i]);
                    operand = stack.push(a);

            }

        }

        return result;
    }
}
