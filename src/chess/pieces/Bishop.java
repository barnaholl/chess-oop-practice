package chess.pieces;

import chess.Color;

public class Bishop extends Piece implements GenericValidation{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Bishop";
    }

    @Override
    public boolean stepValidation(int[] coordinates) {
        return Math.abs(coordinates[0]-coordinates[2])==Math.abs(coordinates[1]-coordinates[3]);
    }
}
