package pl.pawel.linkshell.controller.resolver.impl;


import pl.pawel.linkshell.controller.GameController;
import pl.pawel.linkshell.controller.resolver.Resolver;
import pl.pawel.linkshell.model.player.Player;
import pl.pawel.linkshell.model.player.impl.Gambler;
import pl.pawel.linkshell.model.states.Scoreboard;

import java.util.*;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class GameResolver implements Resolver {

    public static final int FIRST = 0;
    private Scoreboard scoreboard;

    public GameResolver() {
        this.scoreboard = new Scoreboard();
    }

    @Override
    public void resolve(final List<Player> players) {
        List<Player> losers = new ArrayList<>();
        List<Player> candidatesWin = new ArrayList<>();
        for (Player player : players) {
            if (player.getPowerDeck() > GameController.BLACKJACK_VALUE) {
                losers.add(player); 
            } else {
                candidatesWin.add(player);
            }
        }

        Collections.sort(losers);
        Collections.sort(candidatesWin);

        if (!isDraw(losers, candidatesWin)) {
            scoreboard.setWinner(candidatesWin.get(FIRST));
        } else {
            scoreboard.setWinner(new Gambler("DRAW GAME"));
        }
        scoreboard.setLosers(losers);

        Map<Player, Integer> playerRanking = new LinkedHashMap<>();
        for (int i = 0; i < candidatesWin.size(); i++) {
            playerRanking.put(candidatesWin.get(i), candidatesWin.get(i).getPowerDeck());
        }
        for (int i = 0; i < losers.size(); i++) {
            playerRanking.put(losers.get(i), losers.get(i).getPowerDeck());
        }
        scoreboard.setRanking(playerRanking);
    }

    private boolean isDraw(List<Player> losers, List<Player> candidatesWin) {
        if (candidatesWin.size() > 0 && losers.size() > 0) {
            return candidatesWin.get(FIRST).getPowerDeck() == losers.get(FIRST).getPowerDeck();
        }
        return false;
    }

    @Override
    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
