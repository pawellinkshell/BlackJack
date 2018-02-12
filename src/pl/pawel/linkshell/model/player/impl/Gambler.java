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
public class Gambler implements Player {

    private final String name;
    private PlayerDeck deck;

    public Gambler(String name) {
        this.name = name;
        this.deck = new PlayerDeck();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PlayerDeck getDeck() {
        return deck;
    }

    @Override
    public void setDeck(Deck deck) {
        this.deck = (PlayerDeck) deck;
    }

    @Override
    public boolean addCardToDeck(Card card) {
        return deck.addCard(card);
    }

    @Override
    public Decision decide() {
        DecisionStrategy strategy = DecisionStrategyFactory.getStrategy(DecisionStrategyType.PLAYER_LIVE);
        return strategy.decide(name, deck);
    }

    @Override
    public int getPowerDeck() {
        return this.deck.getPowerDeck();
    }

    @Override
    public String toString() {
        return "Gambler{" +
                "name='" + name + '\'' +
                ", deck=" + deck +
                "\npower=" + this.getPowerDeck() +'}';
    }

}
