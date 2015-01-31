package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Board;
import hu.paksyd.tictactoe.Coordinates;

public interface UI {

    public void showBoard(Board board);
    public Coordinates userStep();
}
