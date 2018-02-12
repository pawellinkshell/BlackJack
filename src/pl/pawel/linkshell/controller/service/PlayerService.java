package pl.pawel.linkshell.controller.service;

import pl.pawel.linkshell.model.cards.deck.impl.PlayerDeck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class PlayerService {
    private List<Player> players;

    public PlayerService() {
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Decision getPlayerDecision(Player player) {
        return player.decide();
    }

    public void restartDecks() {
        for (Player player : players) {
            player.setDeck(new PlayerDeck());
        }
    }
}
