package pl.pawel.linkshell.model.player;

import pl.pawel.linkshell.model.cards.Card;
import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public interface Player extends Comparable<Player>{

    boolean addCardToDeck(Card card);

    Decision decide();

    int getPowerDeck();

    String getName();

    Deck getDeck();

    void setDeck(Deck deck);

    @Override
    default int compareTo(Player player) {
        if (this.getPowerDeck() < player.getPowerDeck()) {
            return 1;
        } else if (this.getPowerDeck() == player.getPowerDeck()) {
            return 0;
        } else {
            return -1;
        }
    }
}
