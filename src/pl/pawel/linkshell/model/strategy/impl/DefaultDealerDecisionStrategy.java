package pl.pawel.linkshell.model.strategy.impl;

import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.strategy.DecisionStrategy;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class DefaultDealerDecisionStrategy implements DecisionStrategy {
    private static final DefaultDealerDecisionStrategy instance = new DefaultDealerDecisionStrategy();

    private DefaultDealerDecisionStrategy() {
    }

    // Eager initialized singleton
    public static DefaultDealerDecisionStrategy getInstance() {
        return instance;
    }

    @Override
    public Decision decide(String name, Deck deck) {
        if (deck.getPowerDeck() < 17) {
            return Decision.HIT;
        }
        return Decision.STAND;
    }
}
