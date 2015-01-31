package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Game;
import hu.paksyd.tictactoe.Coordinates;

public interface UI {

    void showBoard(Game game);
    Coordinates userStep();
}
