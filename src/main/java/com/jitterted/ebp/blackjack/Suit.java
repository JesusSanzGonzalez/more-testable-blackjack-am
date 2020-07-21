package com.jitterted.ebp.blackjack;

public class Suit {

    private String suit;

    public Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public static Suit of(String suit){
        return new Suit(suit);
    }

}
