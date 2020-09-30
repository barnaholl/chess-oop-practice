package chess;

import chess.pieces.*;

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
        for(int i=0; i<8; i++){
            board[1][i]=new Pawn(Color.WHITE);
            board[6][i]=new Pawn(Color.BLACK);
        }
        board[0][0]=new Rook(Color.WHITE);
        board[0][1]=new Knight(Color.WHITE);
        board[0][2]=new Bishop(Color.WHITE);
        board[0][3]=new Queen(Color.WHITE);
        board[0][4]=new King(Color.WHITE);
        board[0][5]=new Bishop(Color.WHITE);
        board[0][6]=new Knight(Color.WHITE);
        board[0][7]=new Rook(Color.WHITE);

        board[7][0]=new Rook(Color.BLACK);
        board[7][1]=new Knight(Color.BLACK);
        board[7][2]=new Bishop(Color.BLACK);
        board[7][3]=new Queen(Color.BLACK);
        board[7][4]=new King(Color.BLACK);
        board[7][5]=new Bishop(Color.BLACK);
        board[7][6]=new Knight(Color.BLACK);
        board[7][7]=new Rook(Color.BLACK);

        return board;
    }

    /**
     * table contains the objects
     * @param coordinates
     */
    public void step(int[] coordinates){
        if(board[coordinates[2]][coordinates[3]]!=null){
            System.out.println(board[coordinates[2]][coordinates[3]].getColor()+" "+board[coordinates[2]][coordinates[3]].toString()+" has been removed from the board");
        }
        board[coordinates[2]][coordinates[3]]=board[coordinates[0]][coordinates[1]];
        board[coordinates[0]][coordinates[1]]=null;

    }


}
