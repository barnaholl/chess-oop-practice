package chess;

import chess.pieces.GenericValidation;
import chess.pieces.Knight;
import chess.pieces.Pawn;

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

    public Game() {
        this.round = Color.WHITE;
        this.board = new Board();
    }

    public void step(int[] coordinates) throws IOException {
        if(isStepOnItself(coordinates)){
            System.err.println("Two coordinates are the same");
            step(getInput());
        }
        else if (!isInputInbounds(coordinates)) {
            System.err.println("Input out of bounds");
            step(getInput());
        }
        else if (isFieldEmpty(coordinates[0], coordinates[1])) {
            System.err.println("there is no piece on starting coordinates");
            step(getInput());
        } else if (!isColorsTurn(coordinates[0], coordinates[1])) {
            System.err.println("opponent's piece on starting coordinates");
            step(getInput());
        } else if (!isPieceMovement(coordinates)) {
            System.err.println("Not a valid move");
            step(getInput());
        } else if (isCollide(coordinates)) {
            System.err.println("Cant move without collision");
            step(getInput());

        } else {
            board.step(coordinates);
        }
    }

    private boolean isStepOnItself(int[] coordinates) {
        return coordinates[0]==coordinates[2]&&coordinates[1]==coordinates[3];
    }

    private boolean isCollide(int[] coordinates) {
        if (board.getBoard()[coordinates[0]][coordinates[1]].getClass() == (Knight.class)) {
            return false;
        }
        int deltaX = coordinates[2] - coordinates[0];
        int deltaY = coordinates[3] - coordinates[1];

        if (deltaX == 0 && deltaY > 0) {
            for (int i = 1; i <= deltaY; i++) {
                if (board.getBoard()[coordinates[0]][coordinates[1] + i] != null) {
                    if (i == deltaY && board.getBoard()[coordinates[0]][coordinates[1] + i].getColor() != round) {
                        return false;
                    }
                    return true;
                }
            }
        }
        else if (deltaX == 0 && deltaY < 0) {
            for (int i = -1; i > deltaY - 1; i--) {
                if (board.getBoard()[coordinates[0]][coordinates[1] + i] != null) {
                    if (i == deltaY && board.getBoard()[coordinates[0]][coordinates[1] + i].getColor() != round) {
                        return false;
                    }
                    return true;
                }
            }
        }
        else if (deltaY == 0 && deltaX > 0) {
            for (int i = 1; i <= deltaX; i++) {
                if (board.getBoard()[coordinates[0] + i][coordinates[1]] != null) {
                    if (!(board.getBoard()[coordinates[0]][coordinates[1]] instanceof Pawn)&&i == deltaX && board.getBoard()[coordinates[0] + i][coordinates[1]].getColor() != round) {
                        return false;
                    }
                    return true;
                }
            }
        }
        else if (deltaY == 0 && deltaX < 0) {
            for (int i = -1; i > deltaX - 1; i--) {
                if (board.getBoard()[coordinates[0] + i][coordinates[1]] != null) {
                    if (!(board.getBoard()[coordinates[0]][coordinates[1]] instanceof Pawn)&&i == deltaX && board.getBoard()[coordinates[0] + i][coordinates[1]].getColor() != round) {
                        return false;
                    }
                    return true;
                }
            }
        }
        else if (Math.abs(deltaX) == Math.abs(deltaY)) {
            if (deltaX > 0 && deltaY > 0) {
                for (int i = 1; i <= Math.abs(deltaX); i++) {
                    if (board.getBoard()[coordinates[0] + i][coordinates[1] + i] != null) {
                        if (i == Math.abs(deltaX) && board.getBoard()[coordinates[0] + i][coordinates[1] + i].getColor() != round) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            else if (deltaX > 0 && deltaY < 0) {
                for (int i = 1; i <= Math.abs(deltaX); i++) {
                    if (board.getBoard()[coordinates[0] + i][coordinates[1] - i] != null) {
                        if (i == Math.abs(deltaX) && board.getBoard()[coordinates[0] + i][coordinates[1] - i].getColor() != round) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            else if (deltaX < 0 && deltaY > 0) {
                for (int i = 1; i <= Math.abs(deltaX); i++) {
                    if (board.getBoard()[coordinates[0] - i][coordinates[1] + i] != null) {
                        if (i == Math.abs(deltaX) && board.getBoard()[coordinates[0] - i][coordinates[1] + i].getColor() != round) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            else if (deltaX < 0 && deltaY < 0) {
                for (int i = 1; i <= Math.abs(deltaX); i++) {
                    if (board.getBoard()[coordinates[0] - i][coordinates[1] - i] != null) {
                        if (i == Math.abs(deltaX) && board.getBoard()[coordinates[0] - i][coordinates[1] - i].getColor() != round) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPieceMovement(int[] coordinates) {
        if(board.getBoard()[coordinates[0]][coordinates[1]] instanceof Pawn){
            return ((Pawn) board.getBoard()[coordinates[0]][coordinates[1]]).stepValidation(coordinates,round,board);
        }
        return ((GenericValidation)board.getBoard()[coordinates[0]][coordinates[1]]).stepValidation(coordinates);
    }

    private boolean isColorsTurn(int x, int y) {
        return board.getBoard()[x][y].getColor() == round;
    }

    private boolean isFieldEmpty(int x, int y) {
        return board.getBoard()[x][y] == null;
    }

    private boolean isInputInbounds(int[] coordinates) {
        for (int coordinate : coordinates) {
            if (coordinate < 0 || coordinate >= 8) {
                return false;
            }
        }
        return true;
    }

    private String getInputString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        if (!validateInput(input)) {
            return getInputString();
        }
        return input;
    }

    private boolean validateInput(String input){
        Pattern pattern = Pattern.compile("\\([0-8],[0-8]\\)-\\([0-8],[0-8]\\)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        System.err.println("Invalid input");
        return false;

    }

    public int[] getInput() throws IOException {
        String input = getInputString();
        int[] result = new int[4];
        result[0] = Character.getNumericValue(input.charAt(1));
        result[1] = Character.getNumericValue(input.charAt(3));
        result[2] = Character.getNumericValue(input.charAt(7));
        result[3] = Character.getNumericValue(input.charAt(9));

        return result;
    }
}
