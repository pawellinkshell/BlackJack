package pl.pawel.linkshell.model.strategy;

import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public interface DecisionStrategy {

    Decision decide(String name, Deck deck);

}
