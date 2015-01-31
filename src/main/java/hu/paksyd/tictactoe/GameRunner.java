package hu.paksyd.tictactoe;

import hu.paksyd.tictactoe.ui.ConsoleUI;
import hu.paksyd.tictactoe.ui.UI;

public class GameRunner {

    private final Game game;
    private final UI ui;
    private Player activeUser;

    private final String asciiArt
            = "  _______         ______              ______         \n"
            + " /_  __(_)____   /_  __/___ ______   /_  __/___  ___ \n"
            + "  / / / / ___/    / / / __ `/ ___/    / / / __ \\/ _ \\ \n"
            + " / / / / /__     / / / /_/ / /__     / / / /_/ /  __/ \n"
            + "/_/ /_/\\___/    /_/  \\__,_/\\___/    /_/  \\____/\\___/ ";

    public GameRunner(UI ui) {
        this.game = new Game();
        this.ui = ui;
        this.activeUser = Player.X;
    }

    public void start() {
        System.out.println(asciiArt);

        do {
            showBoard();
            switchPlayer();
            playerStep();
        } while (!game.isGameOver());

        showBoard();

        System.out.println("A nyertes: " + activeUser);
    }

    private void showBoard() {
        System.out.println();
        ui.showBoard(game);
    }

    private void switchPlayer() {
        activeUser = activeUser == Player.X ? Player.O : Player.X;
        System.out.println("Játékos: " + activeUser);
    }

    private void playerStep() {
        Coordinates coordinates = ui.userStep();
        game.step(coordinates, activeUser);
    }

    public static void main(String[] args) {
        new GameRunner(new ConsoleUI()).start();
    }
}
