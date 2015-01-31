package hu.paksyd.tictactoe;

public class Coordinate {

    private final int row;
    private final int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.row;
        hash = 17 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Coordinate other = (Coordinate) obj;
        
        return this.row == other.row && this.column == other.column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
}
