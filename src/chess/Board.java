package chess;

import chess.pieces.Piece;

public class Board {

    private Piece[][] board;

    public Piece[][] getBoard() {
        return board;
    }

    public Board() {
        this.board=boardInit();
    }

    private Piece[][] boardInit(){
        Piece[][] board=new Piece[8][8];
        //TODO:fill the board with specific pieces
        return board;
    }

    /**
     * table contains the objects
     * @param coordinates
     */
    public void step(int[] coordinates){
        //TODO:PieceValidation,InboundValidation,CollisionValidation->LastStep(Colors)
        System.out.println("board.step ran");
        board[coordinates[2]][coordinates[3]]=board[coordinates[0]][coordinates[1]];
        board[coordinates[0]][coordinates[1]]=null;

    }


}
