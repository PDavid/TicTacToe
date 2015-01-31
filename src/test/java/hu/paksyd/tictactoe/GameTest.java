package hu.paksyd.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() {
    }

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void shouldNotGameOverWhenEmpty() {
        Assert.assertFalse(game.isGameOver());
    }

    @Test
    public void shouldNotGameOver() {
//        +X+ + +
//        + + +X+
//        + +X+ +
        step(new Coordinate(1, 1));
        step(new Coordinate(3, 2));
        step(new Coordinate(2, 3));

        Assert.assertFalse(game.isGameOver());
    }

    @Test
    public void shouldGameOverWithSameRow() {
//        +X+X+X+
//        + + + +
//        + + + +
        step(new Coordinate(1, 1));
        step(new Coordinate(1, 2));
        step(new Coordinate(1, 3));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldGameOverWithSameRow2() {
//        + + + +
//        +X+X+X+
//        + + + +
        step(new Coordinate(2, 1));
        step(new Coordinate(2, 2));
        step(new Coordinate(2, 3));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldGameOverWithSameRow3() {
//        + + + +
//        + + + +
//        +X+X+X+
        step(new Coordinate(3, 1));
        step(new Coordinate(3, 2));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldGameOverWithSameColumn() {
//        +X+ + +
//        +X+ + +
//        +X+ + +
        step(new Coordinate(1, 1));
        step(new Coordinate(2, 1));
        step(new Coordinate(3, 1));

        Assert.assertTrue(game.isGameOver());
    }
    
    @Test
    public void shouldGameOverWithSameColumn2() {
//        + +X+ +
//        + +X+ +
//        + +X+ +
        step(new Coordinate(1, 2));
        step(new Coordinate(2, 2));
        step(new Coordinate(3, 2));

        Assert.assertTrue(game.isGameOver());
    }
    
     @Test
    public void shouldGameOverWithSameColumn3() {
//        + + +X+
//        + + +X+
//        + + +X+
        step(new Coordinate(1, 3));
        step(new Coordinate(2, 3));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldGameOverWithSameDiagonal() {
//        +X+ + +
//        + +X+ +
//        + + +X+
        step(new Coordinate(1, 1));
        step(new Coordinate(2, 2));
        step(new Coordinate(3, 3));

        Assert.assertTrue(game.isGameOver());
    }

    @Test
    public void shouldGameOverWithSameDiagonalBackwards() {
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
