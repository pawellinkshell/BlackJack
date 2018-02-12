package pl.pawel.linkshell.model.cards.deck.impl;

import pl.pawel.linkshell.model.cards.Card;
import pl.pawel.linkshell.model.cards.deck.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public class PlayerDeck implements Deck {

    private List<Card> cards;

    public PlayerDeck() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Card getCard(int index) {
        return this.cards.get(index);
    }

    @Override
    public boolean addCard(Card card) {
        return this.cards.add(card);
    }

    @Override
    public int getPowerDeck() {
        int power = 0;
        for (Card card : this.cards) {
            power += card.getRank().getPower();
        }
        return power;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

}
