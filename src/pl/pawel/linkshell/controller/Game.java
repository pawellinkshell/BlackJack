package pl.pawel.linkshell.controller;

import pl.pawel.linkshell.view.impl.GameView;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public class Game {

    private GameController controller;

    public Game(GameController controller) {
        this.controller = controller;
    }

    public boolean prepare() {
        GameView.showBanner();
        return controller.prepare();
    }

    public void run() {

        while (!controller.isGameEnd()) {
            // 1) Start round
            controller.startRound();
            GameView.showRound(controller.getRound());
            GameView.showPlayersDeck(controller.getPlayers());

            // 2) Decision stage of game
            controller.playersMove();
            GameView.showWinner(controller.getScoreboard());
            GameView.showScoreboard(controller.getScoreboard());

            GameView.showCreateNewRound();
            controller.createNewRound();

        }
    }

    public void quit() {
        GameView.showThankYou();
        System.exit(0);
    }
}
