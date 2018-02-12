package pl.pawel.linkshell.model.strategy.impl;

import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.strategy.DecisionStrategy;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class NullDecisionStrategy implements DecisionStrategy {
    private static NullDecisionStrategy instance;

    // static block initialization for exception handling
    private NullDecisionStrategy() {}

    static {
        try {
            instance = new NullDecisionStrategy();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singletion instance");
        }
    }

    public static NullDecisionStrategy getInstance() {
        return instance;
    }

    @Override
    public Decision decide(String name, Deck deck) {
        return null;
    }

}
