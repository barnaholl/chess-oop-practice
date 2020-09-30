package chess.pieces;

import chess.Color;

public abstract class Piece {
    protected Color color;
    protected boolean bypassUnits=false;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }
}
