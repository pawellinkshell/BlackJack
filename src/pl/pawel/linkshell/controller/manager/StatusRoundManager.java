package pl.pawel.linkshell.controller.manager;

import pl.pawel.linkshell.model.enums.manager.StatusRound;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class StatusRoundManager {

    private StatusRound currentStatus;
    private int roundNumber;

    public StatusRoundManager() {
        this.currentStatus = StatusRound.NOT_STARTED;
        this.roundNumber = 0;
    }

    public void startRound() {
        if (currentStatus.equals(StatusRound.FINISHED)) {
            roundNumber = 0;
        }
        roundNumber++;
        currentStatus = StatusRound.IN_PROGRESS;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void endRound() {
        currentStatus = StatusRound.FINISHED;
    }

    public boolean isEnd() {
        return currentStatus.equals(StatusRound.FINISHED) ||
                currentStatus.equals(StatusRound.NOT_STARTED);
    }
}
