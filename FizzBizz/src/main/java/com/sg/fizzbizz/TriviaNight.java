/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fizzbizz;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class TriviaNight {
    public static void main(String[] args) {
        
        
//        It's TRIVIA NIGHT! Are you ready?!
//
//FIRST QUESTION!
//What is the Lowest Level Programming Language?
//1) Source Code		2) Assembly Language
//3) C#				4) Machine Code
//
//YOUR ANSWER: 4
//
//SECOND QUESTION!
//Website Security CAPTCHA Forms Are Descended From the Work of?
//1) Grace Hopper		2) Alan Turing
//3) Charles Babbage		4) Larry Page
//
//YOUR ANSWER: 2
//
//LAST QUESTION!
//Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?
//1) Serenity			2) The Battlestar Galactica
//3) The USS Enterprise	4) The Millennium Falcon
//
//YOUR ANSWER: 3
//
//Nice job - you got 3 correct!
        
        Scanner myReader = new Scanner(System.in);
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        
        System.out.println("What is the Lowest Level Programming Language?\n" +
                "1) Source Code		2) Assembly Language\n" +
                "3) C#				4) Machine Code");
        int answer = myReader.nextInt();
        boolean allCorrect = true;
        if(answer == 4)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
            allCorrect = false;
        }
        
        System.out.println("SECOND QUESTION!\n" +
        "Website Security CAPTCHA Forms Are Descended From the Work of?\n" +
        "1) Grace Hopper		2) Alan Turing\n" +
        "3) Charles Babbage		4) Larry Page");
        
        answer = myReader.nextInt();
        if(answer == 1)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
            allCorrect = false;
        }

        System.out.println("LAST QUESTION!\n" +
        "Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?\n" +
        "1) Serenity			2) The Battlestar Galactica\n" +
        "3) The USS Enterprise	4) The Millennium Falcon");
        
        answer = myReader.nextInt();
        if(answer == 2)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
            allCorrect = false;
        }
        
        if(allCorrect)
        {
            System.out.println("Congratulations you got all correct");
        }
    }
}
