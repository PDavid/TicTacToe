package hu.paksyd.tictactoe;

import hu.paksyd.tictactoe.ui.ConsoleUI;
import hu.paksyd.tictactoe.ui.UI;

public class GameRunner {

    private final Game game;
    private final UI ui;

    public GameRunner(UI ui) {
        this.game = new Game();
        this.ui = ui;
    }

    public void start() {
        ui.showGameTitle();

        do {
            ui.showBoard(game);
            switchPlayer();
            playerStep();
        } while (!game.isGameOver());

        ui.showBoard(game);

        ui.showWinner(game.getActivePlayer());
    }

    private void switchPlayer() {
        game.switchPlayer();
        ui.showActivePlayer(game.getActivePlayer());
    }

    private void playerStep() {
        Coordinate coordinates = ui.playerStep(game);
        game.step(coordinates);
    }

    public static void main(String[] args) {
        new GameRunner(new ConsoleUI()).start();
    }
}
