package chess.pieces;

import chess.Color;

public class Queen extends Piece implements GenericValidation{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Queen";
    }

    @Override
    public boolean stepValidation(int[] coordinates) {
        if(coordinates[0] - coordinates[2] == 0 || coordinates[1] - coordinates[3] == 0){
            return true;
        }
        else return Math.abs(coordinates[0] - coordinates[2]) == Math.abs(coordinates[1] - coordinates[3]);
    }
}
