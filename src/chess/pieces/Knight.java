package chess.pieces;

import chess.Color;

public class Knight extends Piece implements GenericValidation{
    public Knight(Color color) {
        super(color);
        bypassUnits=true;
    }

    @Override
    public String toString() {
        return "Knight";
    }

    @Override
    public boolean stepValidation(int[] coordinates) {
        int deltaX=coordinates[0]-coordinates[2];
        int deltaY=coordinates[1]-coordinates[3];

        return deltaX * deltaX + deltaY * deltaY == 5;
    }

}
