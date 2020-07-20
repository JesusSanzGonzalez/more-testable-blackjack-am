package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Card {
  private final String suit;
  private final String rank;

  public Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public int rankValue() {
    if ("JQK".contains(rank)) {
      return 10;
    } else if (rank.equals("A")) {
      return 1;
    } else {
      return Integer.parseInt(rank);
    }
  }

  //Too long
  public String display() {

    String[] lines = getDispplayCard();

    Ansi.Color cardColor = getColorCard();

    return getDisplayCard(lines, cardColor);
  }

  private String getDisplayCard(String[] lines, Ansi.Color cardColor) {
    return  ansi()
        .fg(cardColor).toString()
        + String.join(ansi().cursorDown(1)
                            .cursorLeft(11)
                            .toString(), lines);
  }

  private Ansi.Color getColorCard() {
    return "♥♦".contains(suit) ? Ansi.Color.RED : Ansi.Color.BLACK;
  }

  private String[] getDispplayCard() {
    String[] lines = new String[7];
    lines[0] = "┌─────────┐";
    lines[1] = String.format("│%s%s       │", rank, rank.equals("10") ? "" : " ");
    lines[2] = "│         │";
    lines[3] = String.format("│    %s    │", suit);
    lines[4] = "│         │";
    lines[5] = String.format("│       %s%s│", rank.equals("10") ? "" : " ", rank);
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
