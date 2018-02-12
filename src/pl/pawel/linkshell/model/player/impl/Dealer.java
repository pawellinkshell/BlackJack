package pl.pawel.linkshell.model.player.impl;

import pl.pawel.linkshell.model.cards.Card;
import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.cards.deck.impl.PlayerDeck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.enums.strategy.DecisionStrategyType;
import pl.pawel.linkshell.model.player.Player;
import pl.pawel.linkshell.model.strategy.DecisionStrategy;
import pl.pawel.linkshell.model.strategy.impl.DecisionStrategyFactory;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public class Dealer implements Player {

    private final int FIRST_CARD = 0;
    private boolean hiddenCard = true;
    private DecisionStrategy strategy;

    private PlayerDeck deck;

    public Dealer(DecisionStrategyType strategyType) {
        this.deck = new PlayerDeck();
        this.strategy = DecisionStrategyFactory.getStrategy(strategyType);
    }

    @Override
    public String getName() {
        return Dealer.class.getSimpleName();
    }

    @Override
    public Deck getDeck() {
        return this.deck;
    }

    @Override
    public void setDeck(Deck deck) {
        this.deck = (PlayerDeck) deck;
    }

    @Override
    public boolean addCardToDeck(Card card) {
        return this.deck.addCard(card);
    }

    @Override
    public Decision decide() {
        hiddenCard = false;
        return strategy.decide(Dealer.class.getName(), deck);
    }

    @Override
    public int getPowerDeck() {
        if (hiddenCard) {
            Card card = deck.getCard(FIRST_CARD);
            return card.getPower();
        }
        return deck.getPowerDeck();
    }

    @Override
    public String toString() {
        if (hiddenCard) {
            return "Dealer{" +
                    "deck=" + deck.getCard(FIRST_CARD) +
                    "\npower=" + this.getPowerDeck() +'}';
        } else {
            return "Dealer{" +
                    "deck=" + deck +
                    "\npower=" + this.getPowerDeck() +'}';
        }
    }
}
