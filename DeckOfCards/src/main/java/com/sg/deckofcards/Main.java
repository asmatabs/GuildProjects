/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.deckofcards;

import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        System.out.println("How manys cards do you want to deal?");
        int num = inputReader.nextInt();
        
        Card[] cards = new Card[num];
        Deck d = new Deck();
        
        cards = d.deal(num);
        
        //Print the cards
        for (int i = 0; i < num; i++)
        {
            
            System.out.println("Card " + (i+1));
            System.out.println("------");
            cards[i].displayCard();
        }
    }
}
