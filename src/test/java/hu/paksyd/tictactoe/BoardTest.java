package hu.paksyd.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;
    private final Player activeUser = Player.X;

    public BoardTest() {
    }

    @Before
    public void setUp() {
        board = new Board();
    }
    
    @Test
    public void shouldNotGameOver() {
        stepAndAssertGameOver(new Coordinates(1, 1), false);
        stepAndAssertGameOver(new Coordinates(3, 2), false);
        stepAndAssertGameOver(new Coordinates(2, 3), false);
    }

    @Test
    public void shouldGameOverWithSameRow() {
        stepAndAssertGameOver(new Coordinates(1, 1), false);
        stepAndAssertGameOver(new Coordinates(1, 2), false);
        stepAndAssertGameOver(new Coordinates(1, 3), true);
    }
    
    @Test
    public void shouldGameOverWithSameColumn() {
        stepAndAssertGameOver(new Coordinates(1, 1), false);
        stepAndAssertGameOver(new Coordinates(2, 1), false);
        stepAndAssertGameOver(new Coordinates(3, 1), true);
    }
    
    @Test
    public void shouldGameOverWithSameDiagonal() {
        stepAndAssertGameOver(new Coordinates(1, 1), false);
        stepAndAssertGameOver(new Coordinates(2, 2), false);
        stepAndAssertGameOver(new Coordinates(3, 3), true);
    }
    
    private void stepAndAssertGameOver(
            Coordinates coordinates, 
            boolean shouldGameOver) {
        
        board.step(coordinates, activeUser);
        System.out.println(board.toString());
        
        Assert.assertEquals(shouldGameOver, board.isGameOver());
    }
}
