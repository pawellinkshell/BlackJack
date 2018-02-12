package pl.pawel.linkshell.model.cards.deck;

import pl.pawel.linkshell.model.cards.Card;

import java.util.List;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public interface Deck {
    int size();
    List<Card> getCards();
    void setCards(List<Card> cards);
    Card getCard(int index);
    boolean addCard(Card card);
    int getPowerDeck();
}
