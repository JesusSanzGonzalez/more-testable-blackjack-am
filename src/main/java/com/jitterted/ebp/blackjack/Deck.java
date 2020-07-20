package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private final List<Card> cards = new ArrayList<>();

  //Too long for a constructor
  public Deck() {
    var cardValues = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    var suits = List.of("♠", "♦", "♥", "♣");
    initDeck(cardValues, suits);
    Collections.shuffle(cards);
  }

  private void initDeck(List<String> cardValues, List<String> suits) {
    for (String suit : suits) {
      for (String cardValue : cardValues) {
        cards.add(new Card(suit, cardValue));
      }
    }
  }

  public int size() {
    return cards.size();
  }

  public Card draw() {
    return cards.remove(0);
  }
}
