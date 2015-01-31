package hu.paksyd.tictactoe.ui;

import hu.paksyd.tictactoe.Board;
import hu.paksyd.tictactoe.Coordinates;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleUI implements UI {

    @Override
    public void showBoard(Board board) {
        System.out.println(board.toString());
    }

    @Override
    public Coordinates userStep() {
        int row = readInt("Add meg a sort (1-3)!");
        int column = readInt("Add meg az oszlopot (1-3)!");
        return new Coordinates(row, column);
    }

    private int readInt(String message) {
        // TODO: A jatekos felul tudja irni mas jatekos poziciojat!
        final int min = 1;
        final int max = 3;
        int number = -1;
        do {
            String userInput = readString(message);
            try {
                number = Integer.parseInt(userInput);
            } catch (NumberFormatException nfe) {
            }
        } while (number < min || number > max);
        return number;
    }

    private String readString(String message) {
        String userInput = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message + " ");
            userInput = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ConsoleUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userInput;
    }
}
