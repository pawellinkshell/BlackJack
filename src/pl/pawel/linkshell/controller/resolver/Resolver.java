package pl.pawel.linkshell.controller.resolver;

import pl.pawel.linkshell.model.player.Player;
import pl.pawel.linkshell.model.states.Scoreboard;

import java.util.List;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public interface Resolver {
    void resolve(List<Player> players);
    Scoreboard getScoreboard();
}
