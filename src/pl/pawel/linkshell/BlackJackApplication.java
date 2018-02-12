package pl.pawel.linkshell;

import pl.pawel.linkshell.controller.Game;
import pl.pawel.linkshell.controller.GameController;
import pl.pawel.linkshell.model.cards.deck.impl.GameDeck;
import pl.pawel.linkshell.model.player.impl.Gambler;

public class BlackJackApplication {

    public static void main(String[] args) {

        // 0) Set application behavior
        GameController controller = new GameController();

        // 1) I am adding new deck into game
        controller.addDeck(new GameDeck(4));
        // 2) I am adding players into game
        controller.addPlayer(new Gambler("Jan"));
        controller.addPlayer(new Gambler("Dawid"));

        // 3) I am creating the game
        Game game = new Game(controller);

        // 4) Prepare competition
        boolean isPrepared = game.prepare();

        // 5) Start game
        if (isPrepared) {
            game.run();
        }

        game.quit();
    }
}
