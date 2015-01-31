package hu.paksyd.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameWinningTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void shouldNotWinWhenEmpty() {
        Assert.assertFalse(game.isGameOver());
    }

    @Test
    public void shouldNotWin() {
//        +X+ + +
//        + + +X+
//        + +X+ +
        step(new Coordinate(1, 1));
        step(new Coordinate(3, 2));
        step(new Coordinate(2, 3));

        Assert.assertFalse(game.isGameOver());
    }

    @Test
    public void shouldWinWithSameRow() {
//        +X+X+X+
//        + + + +
//        + + + +
        step(new Coordinate(1, 1));
        step(new Coordinate(1, 2));
        step(new Coordinate(1, 3));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldWinWithSameRow2() {
//        + + + +
//        +X+X+X+
//        + + + +
        step(new Coordinate(2, 1));
        step(new Coordinate(2, 2));
        step(new Coordinate(2, 3));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldWinWithSameRow3() {
//        + + + +
//        + + + +
//        +X+X+X+
        step(new Coordinate(3, 1));
        step(new Coordinate(3, 2));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldWinWithSameColumn() {
//        +X+ + +
//        +X+ + +
//        +X+ + +
        step(new Coordinate(1, 1));
        step(new Coordinate(2, 1));
        step(new Coordinate(3, 1));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldWinWithSameColumn2() {
//        + +X+ +
//        + +X+ +
//        + +X+ +
        step(new Coordinate(1, 2));
        step(new Coordinate(2, 2));
        step(new Coordinate(3, 2));

        Assert.assertTrue(game.isGameOver());
    }
    
     @Test
    public void shouldWinWithSameColumn3() {
//        + + +X+
//        + + +X+
//        + + +X+
        step(new Coordinate(1, 3));
        step(new Coordinate(2, 3));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldWinWithSameDiagonal() {
//        +X+ + +
//        + +X+ +
//        + + +X+
        step(new Coordinate(1, 1));
        step(new Coordinate(2, 2));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldWinWithSameDiagonalBackwards() {
//        + + +X+
//        + +X+ +
//        +X+ + +
        step(new Coordinate(1, 3));
        step(new Coordinate(2, 2));
        step(new Coordinate(3, 1));

        Assert.assertTrue(game.isGameOver());
    }

    private void step(Coordinate coordinates) {
        game.step(coordinates);
    }
}
