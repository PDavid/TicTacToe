package hu.paksyd.tictactoe;

public class Game {

    private static final char NO_SIGN = ' ';
    private static final char INVALID_SIGN = '_';

    private final char[][] tiles;
    private boolean gameOver;
    private Player activePlayer;

    public Game() {
        tiles = new char[3][3];
        for (char[] row : tiles) {
            for (int j = 0; j < row.length; j++) {
                row[j] = NO_SIGN;
            }
        }
        this.activePlayer = Player.X;
    }

    @Override
    public String toString() {
        StringBuilder textTable = new StringBuilder();
        for (char[] row : tiles) {
            textTable.append("+");
            for (char tile : row) {
                textTable.append(tile).append("+");
            }
            textTable.append("\n");
        }
        return textTable.toString();
    }

    public void step(Coordinate coordinate) {
        int rowIndex = coordinate.getRow() - 1;
        int columnIndex = coordinate.getColumn() - 1;

        tiles[rowIndex][columnIndex] = activePlayer.getCode();

        checkGameOver();
    }
    
    public void switchPlayer() {
        activePlayer = activePlayer == Player.X ? Player.O : Player.X;
    }
    
    private boolean isTileEmpty(Coordinate coordinate) {
        int rowIndex = coordinate.getRow() - 1;
        int columnIndex = coordinate.getColumn() - 1;
        char tile = tiles[rowIndex][columnIndex];
        return tile == NO_SIGN;
    }
    
    public boolean canStepOnTile(Coordinate coordinate) {
        return isTileEmpty(coordinate);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void checkGameOver() {
        // TODO: Should check if nobody can win anymore!
        gameOver = hasSameRow() || hasSameColumn() || hasSameDiagonal()
                || hasSameDiagonalBackwards();
    }

    private boolean hasSameRow() {
        boolean same = true;

        for (char[] row : tiles) {
            same = true;
            char lastTile = INVALID_SIGN;

            for (char tile : row) {
                if (lastTile == INVALID_SIGN) {
                    lastTile = tile;
                } else {
                    if (lastTile == NO_SIGN || lastTile != tile) {
                        same = false;
                        break;
                    }
                }
            }
            if (same) {
                break;
            }
        }

        return same;
    }

    private boolean hasSameColumn() {
        boolean same = true;

        for (int j = 0; j < tiles[0].length; j++) {
            same = true;
            char lastTile = INVALID_SIGN;
            for (int i = 0; i < tiles.length; i++) {
                char tile = tiles[i][j];
                if (lastTile == INVALID_SIGN) {
                    lastTile = tile;
                } else {
                    if (lastTile == NO_SIGN || lastTile != tile) {
                        same = false;
                        break;
                    }
                }
            }
            if (same) {
                break;
            }
        }
        return same;
    }

    private boolean hasSameDiagonal() {
        char lastTile = INVALID_SIGN;
        
        for (int i = 0, j = 0; i < tiles.length && j < tiles[0].length; i++, j++) {
            char tile = tiles[i][j];
            
            if (lastTile == INVALID_SIGN) {
                lastTile = tile;
            } else {
                if (lastTile == NO_SIGN || lastTile != tile) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasSameDiagonalBackwards() {
        char lastTile = INVALID_SIGN;

        for (int i = tiles.length - 1, j = 0; i > 0 && j < tiles[0].length; i--, j++) {
            char tile = tiles[i][j];

            if (lastTile == INVALID_SIGN) {
                lastTile = tile;
            } else {
                if (lastTile == NO_SIGN || lastTile != tile) {
                    return false;
                }
            }
        }

        return true;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
}
