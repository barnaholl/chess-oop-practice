package chess;

import chess.Board;
import chess.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private Color round;
    private Board board;

    public Color getRound() {
        return round;
    }

    public void setRound(Color round) {
        this.round = round;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Game() {
        this.round = Color.WHITE;
        this.board = new Board();
    }

    public void step(int[] coordinates) throws IOException {
        /*if(validateRound(coordinates[0],coordinates[1])){
            board.step(coordinates);
        }
        else{
            getInput();
        }*/
        board.step(coordinates);

    }

    private boolean validateRound(int x,int y){
        if(board.getBoard()[x][y].getColor()==round){
            return true;
        }
        return false;
    }

    private String getInputString() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String input=bufferedReader.readLine();
        validateInput(input);
        return input;
    }
    private String validateInput(String input) throws IOException {
        Pattern pattern=Pattern.compile("\\([0-8],[0-8]\\)-\\([0-8],[0-8]\\)");
        Matcher matcher=pattern.matcher(input);
        if(!matcher.matches()){
            System.err.println("Invalid input");
            return getInputString();
        }
        return input;
    }
    public int[] getInput() throws IOException {
        String input=getInputString();
        int[] result=new int[4];
        result[0]=Character.getNumericValue(input.charAt(1));
        result[1]=Character.getNumericValue(input.charAt(3));
        result[2]=Character.getNumericValue(input.charAt(7));
        result[3]=Character.getNumericValue(input.charAt(9));

        return result;
    }
}
