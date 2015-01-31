package hu.paksyd.tictactoe;

public class Board {

    private static final char NO_SIGN = ' ';
    private static final char INVALID_SIGN = '_';

    private final char[][] tiles;
    private boolean gameOver;

    public Board() {
        tiles = new char[3][3];
        for (char[] row : tiles) {
            for (int j = 0; j < row.length; j++) {
                row[j] = NO_SIGN;
            }
        }
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

    public void step(Coordinates coordinates, Player user) {
        int rowIndex = coordinates.getRow() - 1;
        int columnIndex = coordinates.getColumn() - 1;

        tiles[rowIndex][columnIndex] = user.getCode();

        checkGameOver();
    }

    private void checkGameOver() {
        gameOver = hasSameRow() || hasSameColumn() || hasSameDiagonal();
//        System.out.println("gameOver: " + gameOver);
    }

    private boolean hasSameRow() {
        boolean same = true;

        for (char[] row : tiles) {
            same = true;
            char lastTile = INVALID_SIGN;

            for (char tile : row) {
//                System.out.println("  lastTile: " + lastTile + ", tile: " + tile);
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
//                System.out.println("  lastTile: " + lastTile + ", tile: " + tile);
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
        // TODO: Implement the diagonal pattern check!
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
