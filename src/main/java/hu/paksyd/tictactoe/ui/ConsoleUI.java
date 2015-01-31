package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Game;
import hu.paksyd.tictactoe.Coordinates;
import hu.paksyd.tictactoe.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleUI implements UI {

    private final String gameTitle
            = "  _______         ______              ______         \n"
            + " /_  __(_)____   /_  __/___ ______   /_  __/___  ___ \n"
            + "  / / / / ___/    / / / __ `/ ___/    / / / __ \\/ _ \\ \n"
            + " / / / / /__     / / / /_/ / /__     / / / /_/ /  __/ \n"
            + "/_/ /_/\\___/    /_/  \\__,_/\\___/    /_/  \\____/\\___/ ";

    @Override
    public void showGameTitle() {
        System.out.println(gameTitle);
    }

    @Override
    public void showBoard(Game game) {
        System.out.println();
        System.out.println(game.toString());
    }

    @Override
    public void showActivePlayer(Player player) {
        System.out.println("Játékos: " + player);
    }

    @Override
    public Coordinates userStep() {
        int row = readInt("Add meg a sort (1-3)!");
        int column = readInt("Add meg az oszlopot (1-3)!");
        return new Coordinates(row, column);
    }

    private int readInt(String message) {
        // TODO: The player should not be able to override any tile!
        final int min = 1;
        final int max = 3;
        int number = -1;
        do {
            String userInput = readString(message);
            try {
                number = Integer.parseInt(userInput);
            } catch (NumberFormatException nfe) {
            }
        } while (number < min || number > max);
        return number;
    }

    private String readString(String message) {
        String userInput = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message + " ");
            userInput = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userInput;
    }

    @Override
    public void showWinner(Player player) {
        System.out.println("A nyertes: " + player);
    }
}
