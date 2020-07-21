package com.jitterted.ebp.blackjack;

public class Rank {

    private String rank;

    public Rank(String rank) {
        this.rank = rank;
    }

    public int rankValue() {  //Moving this method changes observability on card.
        if (isFaceCard()) {
            return 10;
        } if (isAce()) {
            return 1;
        }
        return numericValue();

    }

    private int numericValue() {
        return Integer.parseInt(rank);
    }

    private boolean isAce() {
        return rank.equals("A");
    }

    private boolean isFaceCard() {
        return "JQK".contains(rank);
    }

    public String display(){
        return rank + (rank.equals("10") ? "" : " ");
    }
}
