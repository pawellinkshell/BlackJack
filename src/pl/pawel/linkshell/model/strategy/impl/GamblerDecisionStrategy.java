package pl.pawel.linkshell.model.strategy.impl;

import pl.pawel.linkshell.model.cards.deck.Deck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.strategy.DecisionStrategy;

import java.util.Scanner;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class GamblerDecisionStrategy implements DecisionStrategy {
    private static GamblerDecisionStrategy instance;

    private GamblerDecisionStrategy() {
    }

    public static GamblerDecisionStrategy getInstance() {
        // Lazy initialized singleton
        if (instance == null) {
            instance = new GamblerDecisionStrategy();
        }
        return instance;
    }

    @Override
    public Decision decide(String name, Deck deck) {
        return getDecisionFromKeyboard();
    }

    private Decision getDecisionFromKeyboard() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine();
            if (isInputValidated(input)) {
                for (Decision decision : Decision.values()) {
                    if (decision.ordinal() == Integer.parseInt(input)) {
                        return decision;
                    }
                }
            } else {
                System.out.println("Invalid input, try again!\n>>");
            }
        }
    }

    private boolean isInputValidated(String input) {
        return isInteger(input) && isInDecisionRange(input);
    }

    private boolean isInDecisionRange(String input) {
        int decisionNumber = Integer.parseInt(input);
        for (Decision decision : Decision.values()) {
            if (decision.ordinal() == decisionNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
