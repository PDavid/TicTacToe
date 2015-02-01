package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Game;
import hu.paksyd.tictactoe.Coordinate;
import hu.paksyd.tictactoe.Player;

public interface UI {
    void showGameTitle();
    void showBoard(Game game);
    void showActivePlayer(Player player);
    Coordinate playerStep(Game game);
    void showWinner(Player player);
    void showNoWinner();
}
