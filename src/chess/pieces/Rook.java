package chess.pieces;

import chess.Color;

public class Rook extends Piece implements GenericValidation{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Rook";
    }

    @Override
    public boolean stepValidation(int[] coordinates) {
        return coordinates[0] - coordinates[2] == 0 || coordinates[1] - coordinates[3] == 0;
    }
}
