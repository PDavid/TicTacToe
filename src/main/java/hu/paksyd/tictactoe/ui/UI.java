package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Game;
import hu.paksyd.tictactoe.Coordinates;
import hu.paksyd.tictactoe.Player;

public interface UI {
    void showGameTitle();
    void showBoard(Game game);
    void showActivePlayer(Player player);
    Coordinates userStep();
    void showWinner(Player player);
}
