package pl.pawel.linkshell.controller;

import pl.pawel.linkshell.controller.resolver.impl.GameResolver;
import pl.pawel.linkshell.controller.service.DeckService;
import pl.pawel.linkshell.controller.service.PlayerService;
import pl.pawel.linkshell.controller.service.RoundService;
import pl.pawel.linkshell.model.cards.deck.impl.GameDeck;
import pl.pawel.linkshell.model.enums.manager.Decision;
import pl.pawel.linkshell.model.enums.strategy.DecisionStrategyType;
import pl.pawel.linkshell.model.player.Player;
import pl.pawel.linkshell.model.player.impl.Dealer;
import pl.pawel.linkshell.model.states.Scoreboard;
import pl.pawel.linkshell.view.impl.PlayerDecisionView;

import java.util.List;
import java.util.Scanner;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class GameController {

    public static final int BLACKJACK_VALUE = 21;

    private RoundService roundService;
    private DeckService deckService;
    private PlayerService playerService;

    private GameResolver gameResolver;

    public GameController() {
        this.roundService = new RoundService();
        this.deckService = new DeckService();
        this.playerService = new PlayerService();
        this.gameResolver = new GameResolver();
    }

    public void startRound() {
        roundService.start();
        playerService.restartDecks();
        deckService.giveFirstCardsAway(playerService.getPlayers());
    }

    public boolean addDeck(GameDeck deck) {
        return this.deckService.addDeck(deck);
    }

    public boolean addPlayer(Player player) {
        return this.playerService.addPlayer(player);
    }

    public void playersMove() {
        // TODO ten mechanizm jest zjebany do refaktoryzacji, za du¿y!!
        for (Player player : playerService.getPlayers()) {
            boolean isTourEnd = false;
            while (!isTourEnd) {
                if (isMaximumPowerDeckReach(player, BLACKJACK_VALUE)) {
                    break;
                } else {
        // TODO co to krwa jest widok w kontrolerze?!, ³amiesz kontrkat MVC!! Do wyjebania
                    PlayerDecisionView.showPlayerDecision(player.getName(), player.getDeck());
                    Decision decision = playerService.getPlayerDecision(player);

        // TODO ten mechanizm powinien zostaæ wydzielony do nowego lub istniej¹cego serwisu
                    switch (decision) {
                        case HIT:
                            deckService.addCardForPlayer(player);
                            continue;
                        case STAND:
                            isTourEnd = true;
                            break;
                        case DOUBLE_DOWN:
                            throw new IllegalArgumentException("Not yet implemented");
                        case INSURANCE:
                            throw new IllegalArgumentException("Not yet implemented");
                        case SPLIT:
                            throw new IllegalArgumentException("Not yet implemented");
                        default:
                    }
                }
            }
        }

    }

    private boolean isMaximumPowerDeckReach(Player player, int blackjackValue) {
        return player.getPowerDeck() > blackjackValue;
    }

    public boolean prepare() {
        // 0) Flag for configuration checks
        boolean start = false;

        // 1) Add Dealer into game
        start = playerService.addPlayer(new Dealer(DecisionStrategyType.PLAYER_AI_DEFAULT));

        if (!isEnoughPlayers()) {
            return false;
        }

        // 2) Shuffle whole cards in game deck
        start = deckService.shuffleGameDeck();

        return start;
    }

    private boolean isEnoughPlayers() {
        return playerService.getPlayers().size() > 1;
    }

    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    public Scoreboard getScoreboard() {
        gameResolver.resolve(playerService.getPlayers());
        return gameResolver.getScoreboard();
    }

    public int getRound() {
        return this.roundService.getRound();
    }

    public boolean createNewRound() {
        Scanner in = new Scanner(System.in);

        // TODO chujowa obs³uga klawiatury, do przerobienia
        while (true) {
            String input = in.nextLine();
            if (isInputValidated(input)) {
                if (isPositive(input)) {
                    return true;
                } else {
                    roundService.end();
                    return false;
                }
            } else {
                System.out.println("Invalid input, try again!\n>>");
            }
        }
    }

    private boolean isInputValidated(String input) {
        return isPositive(input) || isNegative(input);
    }

    private boolean isNegative(String input) {
        return input.equalsIgnoreCase("N");
    }

    private boolean isPositive(String input) {
        return input.equalsIgnoreCase("Y");
    }

    public boolean isGameEnd() {
        return this.roundService.isGameEnd();
    }
}
