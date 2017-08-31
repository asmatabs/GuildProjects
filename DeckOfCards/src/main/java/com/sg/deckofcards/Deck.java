/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.deckofcards;

import java.util.Random;

/**
 *
 * @author asmat
 */
public class Deck {
 
    public static final int SUITS = 4;
    public static final int CARDS_IN_SUIT = 13;
    Card[][] cards;
    
    public Deck()
    {
        cards = new Card[SUITS][CARDS_IN_SUIT];
        for( int i = 0; i < SUITS; i++)
        {
            for (int j = 0; j < CARDS_IN_SUIT; j++)
            {
                cards[i][j] = new Card(i+1, j+1);
            }
        }
    }
    
    public Card[] deal(int numberToDeal)
    {
        Card[] cardsDealt = new Card[numberToDeal];

        //Generate two random number: 1 between 1-4, 2 between 1-13
        Random randomizer = new Random();
        
        for( int i = 0; i < numberToDeal; )
        {
            boolean cardTaken = false;
            int randomSuit = randomizer.nextInt(SUITS) + 1;
            int randomFace = randomizer.nextInt(CARDS_IN_SUIT) + 1;
            
            //Check if this card is already drawn
            for (int j = 0; j<i;j++)
            {
                if (cardsDealt[j].getFace() == randomFace 
                    && cardsDealt[j].getSuit()== randomSuit)
                {
                    cardTaken = true;
                    break;
                }
            }
            if (cardTaken == true)
            {
                continue;
            }
            cardsDealt[i] = cards[randomSuit-1][randomFace-1];
            i++;
        }
        return cardsDealt;
    }
    
}
