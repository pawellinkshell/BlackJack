package pl.pawel.linkshell.model.states;

import pl.pawel.linkshell.model.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class Scoreboard {
    private List<Player> losers;
    private Map<Player, Integer> playerRanking;
    private Player winner;

    public Scoreboard() {
        this.playerRanking = new HashMap<>();
    }

    public Player getWinner() {
        return this.winner;
    }

    public List<Player> getLosers() {
        return this.losers;
    }

    public Map<Player, Integer> getPlayerRanking() {
        return this.playerRanking;
    }

    public void setWinner(Player player) {
        this.winner = player;
    }

    public void setLosers(List<Player> losers) {
        this.losers = losers;
    }

    public void setRanking(Map<Player, Integer> playerRanking) {
        this.playerRanking = playerRanking;
    }
}
