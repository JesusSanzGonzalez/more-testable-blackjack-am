package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private final List<Card> cards = new ArrayList<>();

  public Deck() {
    var cardValues = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"); //primitive Obsession
    var suits = List.of("♠", "♦", "♥", "♣");  //primitive Obsession
    for (String suit : suits) {
      for (String cardValue : cardValues) {
        cards.add(new Card(Suit.of(suit), cardValue));
      }
    }
    Collections.shuffle(cards);
  }

  public int size() {
    return cards.size();
  }

  public Card draw() {
    return cards.remove(0);
  }
}
