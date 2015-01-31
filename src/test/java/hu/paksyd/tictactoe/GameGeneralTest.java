package hu.paksyd.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameGeneralTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void activePlayerShouldBeDifferentAfterSwitch() {
        Player firstPlayer = game.getActivePlayer();
        game.switchPlayer();
        Assert.assertNotSame(firstPlayer, game.getActivePlayer());
    }
    
    @Test
    public void stepShouldMakeTileNotEmpty() {
        Coordinate coorddinate = new Coordinate(1, 1);
        game.step(coorddinate);
        Assert.assertFalse(game.canStepOnTile(coorddinate));
    }
}
