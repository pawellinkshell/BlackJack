package pl.pawel.linkshell.model.cards;

import pl.pawel.linkshell.model.enums.card.Rank;
import pl.pawel.linkshell.model.enums.card.Suit;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }


    @Override
    public String toString() {
        return "\n\tCard{" +
                "suit=" + suit +
                ", rank=" + rank +
                "}";
    }

    public int getPower() {
        return rank.getPower();
    }
}
