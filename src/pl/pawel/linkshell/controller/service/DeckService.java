package pl.pawel.linkshell.controller.service;

import pl.pawel.linkshell.model.cards.Card;
import pl.pawel.linkshell.model.cards.deck.impl.GameDeck;
import pl.pawel.linkshell.model.player.Player;

import java.util.List;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class DeckService {
    public static final int FIRST = 0;

    private GameDeck gameDeck;

    public Card pollCardFromDeck() {
        return gameDeck.pollCard();
    }

    public GameDeck getDeck() {
        return gameDeck;
    }

    public boolean createGameDeck() {
        return false;
    }

    public int getDeckSize() {
        return this.gameDeck.size();
    }

    public boolean addDeck(GameDeck deck) {
        if (this.gameDeck == null || this.gameDeck.size() == 0) {
            this.gameDeck = deck;
            return true;
        }
        return false;
    }

    public boolean giveFirstCardsAway(List<Player> players) {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                boolean hasCardInDeck = this.addCardForPlayer(player);
                if (!hasCardInDeck) {
                    // Deck is empty, cannot play
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addCardForPlayer(Player player) {
        Card card = pollCardFromDeck();
        if (card == null) {
            return false;
        }
        return player.addCardToDeck(card);
    }

    public boolean shuffleGameDeck() {
        if (getDeck() != null && getDeckSize() > 0) {
            getDeck().shuffle();
            return true;
        }
        return false;
    }
}
