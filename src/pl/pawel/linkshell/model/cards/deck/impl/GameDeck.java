package pl.pawel.linkshell.model.cards.deck.impl;

import pl.pawel.linkshell.model.cards.Card;
import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.card.Rank;
import pl.pawel.linkshell.model.enums.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class GameDeck implements Deck {
    private static final int ONE_DECK_CARDS_SIZE = 52;
    private static final int FIRST_CARD = 0;
    private static final int SIZE_OF_MAX_DECKS = 8;

    private int amountOfDecks = 0;

    private List<Card> cards;

    public GameDeck() {
        this.cards = new ArrayList<>();
    }

    public GameDeck(int amountOfDecks) {
        this();

        if (amountOfDecks <= SIZE_OF_MAX_DECKS) {
            for (int i = 0; i < amountOfDecks; i++) {
                addDeck();
            }
        }
    }

    private boolean addDeck() {
        if (isCurrentDeckLessThanMaxDeck() || isDeckEmpty()) {
            createOneFullDeck();
            this.amountOfDecks++;
            return true;
        }

        return false;
    }

    private List<Card> createOneFullDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

    private boolean isDeckEmpty() {
        return this.amountOfDecks == 0;
    }

    private boolean isCurrentDeckLessThanMaxDeck() {
        return cards.size() <= ONE_DECK_CARDS_SIZE * SIZE_OF_MAX_DECKS;
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
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
        return "GameDeck{" +
                "amountOfDecks=" + amountOfDecks +
                ", cards=" + cards +
                ", power= " + getPowerDeck() +'}';
    }

    public int getAmountOfDecks() {
        return this.amountOfDecks;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card pollCard() {
        Card card = null;
        if (cards.size() > 0) {
            card = cards.remove(FIRST_CARD);
        }

        // decrease amount of decks if one deck of cards has been exhausted
        if (cards.size() % ONE_DECK_CARDS_SIZE == 0) {
            this.amountOfDecks--;
        }
        return card;
    }
}
