package chess.pieces;

import chess.Board;
import chess.Color;

public class Pawn extends Piece implements RoundDependantValidation {
    private boolean isFirstStep;

    public Pawn(Color color) {
        super(color);
        isFirstStep=true;
    }

    @Override
    public String toString() {
        return "Pawn";
    }

    public boolean stepValidation(int[] coordinates, Color color, Board board) {
        if(color==Color.WHITE){
            if(isFirstStep&&coordinates[3]-coordinates[1]==0&&coordinates[2]-coordinates[0]>0&&coordinates[2]-coordinates[0]<=2){
                isFirstStep=false;
                return true;
            }
            else if(coordinates[2]-coordinates[0]==1&&Math.abs(coordinates[3]-coordinates[1])==1){
                    return board.getBoard()[coordinates[2]][coordinates[3]].getColor()==Color.BLACK;
            }
            return coordinates[3]-coordinates[1]==0&&coordinates[2]-coordinates[0]==1;
        }
        else if(isFirstStep&&coordinates[3]-coordinates[1]==0&&coordinates[2]-coordinates[0]<0&&coordinates[2]-coordinates[0]>=-2){
            isFirstStep=false;
            return true;
        }
        else if(coordinates[2]-coordinates[0]==-1&&Math.abs(coordinates[3]-coordinates[1])==1){
            return board.getBoard()[coordinates[2]][coordinates[3]].getColor()==Color.WHITE;
        }
        return coordinates[3]-coordinates[1]==0&&coordinates[2]-coordinates[0]==-1;

    }
}
