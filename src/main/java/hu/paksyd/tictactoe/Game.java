package hu.paksyd.tictactoe;

import hu.paksyd.tictactoe.ui.ConsoleUI;
import hu.paksyd.tictactoe.ui.UI;

public class Game {

    private final Board board;
    private final UI ui;

    public Game(UI ui) {
        board = new Board();
        this.ui = ui;
    }

    public void start() {
        System.out.println("Tic Tac Toe");

        Player activeUser = Player.X;
        do {
            System.out.println();
            
            ui.showBoard(board);
            
            activeUser = activeUser == Player.X ? Player.O : Player.X;
            System.out.println("Játékos: " + activeUser);
            Coordinates coordinates = ui.userStep();
            board.step(coordinates, activeUser);
        } while (!board.isGameOver());

        System.out.println("A nyertes: " + activeUser);
    }

    public static void main(String[] args) {
        new Game(new ConsoleUI()).start();
    }
}
