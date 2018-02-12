package pl.pawel.linkshell.view.impl;

import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.view.View;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class PlayerDecisionView implements View {
    public static void showPlayerDecision(String name, Deck deck) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "\n ___               _      _" +
                "\n|   \\   ___   __  (_)  __| |  ___" +
                "\n| |) | / -_) / _| | | / _` | / -_)" +
                "\n|___/  \\___| \\__| |_| \\__,_| \\___|"
        );
        sb.append("\n" + name + " cards: " + deck.getCards());
        sb.append("\n" + name + " deck power: " + deck.getPowerDeck());
        sb.append("\n\nDecide " + name + ":");
        for (int i = 0; i < Decision.values().length; i++) {
            sb.append("\n" + i + " - " + Decision.values()[i].name());
        }
        sb.append("\n>> ");
        show(sb.toString());
    }

    private static void show(String s) {
        System.out.println(s);
    }
}
