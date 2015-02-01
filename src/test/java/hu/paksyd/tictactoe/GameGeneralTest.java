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
    
    @Test
    public void boardShouldNotBeFullWithEmptyBoard() {
        Assert.assertFalse(game.isBoardFull());
    }
    
    @Test
    public void boardShouldNotBeFull() {
//        +X+ + +
//        + + +X+
//        + +X+ +
        game.step(new Coordinate(1, 1));
        game.step(new Coordinate(3, 2));
        game.step(new Coordinate(2, 3));

        Assert.assertFalse(game.isBoardFull());
    }
    
     @Test
    public void boardShouldBeFull() {
        game.step(new Coordinate(1, 1));
        game.step(new Coordinate(1, 2));
        game.step(new Coordinate(1, 3));
        
        game.step(new Coordinate(2, 1));
        game.step(new Coordinate(2, 2));
        game.step(new Coordinate(2, 3));
        
        game.step(new Coordinate(3, 1));
        game.step(new Coordinate(3, 2));
        game.step(new Coordinate(3, 3));

        Assert.assertTrue("The board should be full.", game.isBoardFull());
    }
}
