package pl.pawel.linkshell.view.impl;

import pl.pawel.linkshell.model.player.Player;
import pl.pawel.linkshell.model.states.Scoreboard;
import pl.pawel.linkshell.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class GameView implements View {

    public static void showPlayersDeck(List<Player> players) {
        for (Player player : players) {
           show(player + "\n");
        }
    }

    public static void showBanner() {
        StringBuilder sb = new StringBuilder();
        sb.append(
            "\n,-----.   ,--.                 ,--.          ,--.                 ,--." +
            "\n|  |) /_  |  |  ,--,--.  ,---. |  |,-.       |  |  ,--,--.  ,---. |  |,-." +
            "\n|  .-.  \\ |  | ' ,-.  | | .--' |     /  ,--. |  | ' ,-.  | | .--' |     /" +
            "\n|  '--' / |  | \\ '-'  | \\ `--. |  \\  \\  |  '-'  / \\ '-'  | \\ `--. |  \\  \\" +
            "\n`------'  `--'  `--`--'  `---' `--'`--'  `-----'   `--`--'  `---' `--'`--'"
        );
        sb.append("\n----------------");
        sb.append("\nCreated by Jan Koszela 2018");
        sb.append("\n----------------");

        show(sb.toString());
    }

    public static void showThankYou() {
        StringBuilder sb = new StringBuilder();
        sb.append(
        "\n::::::::::: :::    :::     :::     ::::    ::: :::    :::        :::   :::  ::::::::  :::    :::" +
        "\n    :+:     :+:    :+:   :+: :+:   :+:+:   :+: :+:   :+:         :+:   :+: :+:    :+: :+:    :+:" +
        "\n    +:+     +:+    +:+  +:+   +:+  :+:+:+  +:+ +:+  +:+           +:+ +:+  +:+    +:+ +:+    +:+" +
        "\n    +#+     +#++:++#++ +#++:++#++: +#+ +:+ +#+ +#++:++             +#++:   +#+    +:+ +#+    +:+" +
        "\n    +#+     +#+    +#+ +#+     +#+ +#+  +#+#+# +#+  +#+             +#+    +#+    +#+ +#+    +#+" +
        "\n    #+#     #+#    #+# #+#     #+# #+#   #+#+# #+#   #+#            #+#    #+#    #+# #+#    #+#" +
        "\n    ###     ###    ### ###     ### ###    #### ###    ###           ###     ########   ########"
        );

        show(sb.toString());
    }

    public static void showScoreboard(Scoreboard scoreboard) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- SCOREBOARD -----------");

        int iter = 1;
        for (Map.Entry<Player, Integer> entry : scoreboard.getPlayerRanking().entrySet()) {
            sb.append("\n" + iter + " - " + entry.getKey().getName()
                    + ", power = " + entry.getValue()
                    + "\ndeck = " + entry.getKey().getDeck());
            iter++;
        }
        sb.append("\n----- SCOREBOARD -----------");
        show(sb.toString());
    }

    public static void showWinner(Scoreboard scoreboard) {
        StringBuilder sb = new StringBuilder();
        sb.append(
        "\n,--------. ,--.                ,--.   ,--. ,--.                                     ,--." +
        "\n'--.  .--' |  ,---.   ,---.    |  |   |  | `--' ,--,--,  ,--,--,   ,---.  ,--.--.   `--'  ,---.  .--." +
        "\n   |  |    |  .-.  | | .-. :   |  |.'.|  | ,--. |      \\ |      \\ | .-. : |  .--'   ,--. (  .-'  '--'" +
        "\n   |  |    |  | |  | \\   --.   |   ,'.   | |  | |  ||  | |  ||  | \\   --. |  |      |  | .-'  `) .--." +
        "\n   `--'    `--' `--'  `----'   '--'   '--' `--' `--''--' `--''--'  `----' `--'      `--' `----'  '--'"
        );
        sb.append("\n" + scoreboard.getWinner().getName());

        show(sb.toString());
    }

    private static void show(String s) {
        System.out.println(s);
    }

    public static void showRound(int round) {
        StringBuilder sb = new StringBuilder();
        sb.append(
        "\n _" +
        "\n|_) _    __  _|" +
        "\n| \\(_)|_|| |(_|"
        );
        sb.append("  " + round);
        sb.append("\n-------------------");

        show(sb.toString());
    }

    public static void showCreateNewRound() {
        StringBuilder sb = new StringBuilder();
        sb.append(
            "\nWant to play next game:" +
            "\n[Y]es " +
            "\n[N]o "
        );

        show(sb.toString());
    }
}
