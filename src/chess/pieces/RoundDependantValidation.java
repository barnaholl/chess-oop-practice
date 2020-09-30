package chess.pieces;

import chess.Board;
import chess.Color;

public interface RoundDependantValidation {
    boolean stepValidation(int[] coordinates, Color round, Board board);
}
