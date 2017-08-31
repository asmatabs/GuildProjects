/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.deckofcards;

/**
 *
 * @author asmat
 */
public class Card {

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int SPADES = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    public static final int CLUBS = 4;

    private int suit;
    private int face;

    /**
     * @return the suit
     */
    public int getSuit() {
        return suit;
    }

    /**
     * @return the face
     */
    public int getFace() {
        return face;
    }

    public Card() {
    }

    public Card(int suit, int face) {
        this.face = face;
        this.suit = suit;
    }

    public void displayCard() {

        System.out.println("SUIT        " + suitToString());
        System.out.println("FACE        " + faceToString());
    }

    public String suitToString() {
        String suitStr = "";
        switch (this.suit) {
            case SPADES:
                suitStr = "SPADES";
                break;
            case DIAMONDS:
                suitStr = "DIAMONDS";
                break;
            case HEARTS:
                suitStr = "HEARTS";
                break;
            case CLUBS:
                suitStr = "CLUBS";
                break;
        }
        return suitStr;
    }

    public String faceToString() {

        String faceStr = "";
        switch (this.face) {
            case ACE:
                faceStr = "ACE";
                break;
            case TWO:
                faceStr = "TWO";
                break;
            case THREE:
                faceStr = "THREE";
                break;
            case FOUR:
                faceStr = "FOUR";
                break;
            case FIVE:
                faceStr = "FIVE";
                break;
            case SIX:
                faceStr = "SIX";
                break;
            case SEVEN:
                faceStr = "SEVEN";
                break;
            case EIGHT:
                faceStr = "EIGHT";
                break;
            case NINE:
                faceStr = "NINE";
                break;
            case TEN:
                faceStr = "TEN";
                break;
            case JACK:
                faceStr = "JACK";
                break;
            case QUEEN:
                faceStr = "QUEEN";
                break;
            case KING:
                faceStr = "KING";
                break;
        }
        return faceStr;
    }

}
