package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Card {
  private final Suit suit;  //primitive Obsession
  private final Rank rank;  //primitive Obsession

  // 3 reasons to extract Rank as a separate class

  // * Compare cards vs. another cards (new behavior)
  // * Makes testing rank value private methods easier/possible
  // * Encapsulates logic into ine plate
  // * Valication
  // * Inmutability
  // * Give it a good name

  public Card(Suit suit, String rank) {
    this.suit = suit;
    this.rank = new Rank(rank);
  }

  //This is needed to ensure we do not change observability.
  //We are delegating
  public int rankValue(){
    return rank.rankValue();
  }

  public String display() {
    String[] lines = getDisplayCard();

    Ansi.Color cardColor = "♥♦".contains(suit.getSuit()) ? Ansi.Color.RED : Ansi.Color.BLACK;  //primitive Obsession "♥♦"
    return ansi()
        .fg(cardColor).toString()
        + String.join(ansi().cursorDown(1)
                            .cursorLeft(11)
                            .toString(), lines);
  }

  private String[] getDisplayCard() {
    String[] lines = new String[7];
    lines[0] = "┌─────────┐";
    lines[1] = String.format("│%s       │", rank.display());
    lines[2] = "│         │";
    lines[3] = String.format("│    %s    │", suit);
    lines[4] = "│         │";
    lines[5] = String.format("│       %s│", rank.display());
    lines[6] = "└─────────┘";
    return lines;
  }

  @Override
  public String toString() {
    return "Card {" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Card card = (Card) o;

    if (!suit.equals(card.suit)) return false;
    return rank.equals(card.rank);
  }

  @Override
  public int hashCode() {
    int result = suit.hashCode();
    result = 31 * result + rank.hashCode();
    return result;
  }
}
