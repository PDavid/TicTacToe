package hu.paksyd.tictactoe;

public enum Player {

    X('X'),
    O('O');

    private final char code;

    private Player(char code) {
        this.code = code;
    }
    
    public char getCode() {
        return code;
    }

}
