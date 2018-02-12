package pl.pawel.linkshell.controller.service;

import pl.pawel.linkshell.controller.manager.StatusRoundManager;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class RoundService {
    private StatusRoundManager roundManager;
    private boolean gameEnd;

    public RoundService() {
        this.roundManager = new StatusRoundManager();
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public boolean isRoundEnd() {
        return roundManager.isEnd();
    }

    public void start() {
        roundManager.startRound();
        this.gameEnd = false;
    }

    public int getRound() {
        return this.roundManager.getRoundNumber();
    }

    public void end() {
        this.roundManager.endRound();
        this.gameEnd = true;
    }
}
