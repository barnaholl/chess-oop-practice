package chess.pieces;

import chess.Color;

public class King extends Piece implements GenericValidation{
    public King(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "King";
    }

    @Override
    public boolean stepValidation(int[] coordinates) {
        return Math.abs(coordinates[0]-coordinates[2])<=1&&Math.abs(coordinates[1]-coordinates[3])<=1;
    }
}
