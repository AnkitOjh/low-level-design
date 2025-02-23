package chess;

import exception.IllegalMove;
import pieces.*;

public class Board {

    private final Piece[][] board;
    public Board(){
        board = new Piece[8][8];
        board[0][0] = new Rook(Color.WHITE, 0, 0);
        board[0][1] = new Knight(Color.WHITE, 0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE, 0, 4);
        board[0][5] = new Bishop(Color.WHITE, 0, 5);
        board[0][6] = new Knight(Color.WHITE, 0, 6);
        board[0][7] = new Rook(Color.WHITE, 0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        // Initialize black pieces
        board[7][0] = new Rook(Color.BLACK, 7, 0);
        board[7][1] = new Knight(Color.BLACK, 7, 1);
        board[7][2] = new Bishop(Color.BLACK, 7, 2);
        board[7][3] = new Queen(Color.BLACK, 7, 3);
        board[7][4] = new King(Color.BLACK, 7, 4);
        board[7][5] = new Bishop(Color.BLACK, 7, 5);
        board[7][6] = new Knight(Color.BLACK, 7, 6);
        board[7][7] = new Rook(Color.BLACK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, 6, i);
        }

    }
    public Piece[][] getBoard(){
        return this.board;
    }

    public void move(int row,int col,int distRow,int distCol,Color color){
        if(board[row][col] != null){
            Piece piece = board[row][col];
            if(piece.getColor().equals(color)){
                Piece piece1 = board[distRow][distCol];
                if(piece1 == null){
                    if(piece.canMove(this,distRow,distCol) == true){
                        piece.setRow(distRow);
                        piece.setCol(distCol);

                    } else{
                        throw new IllegalMove("Iilegal move ");
                    }

                }
                else{
                    if(!piece1.getColor().equals(color)){
                        if(piece.canMove(this,distRow,distCol) == true){
                            piece.setRow(distRow);
                            piece.setCol(distCol);
                            System.out.println("You have cut piece");
                            piece1.setRow(-1);
                            piece1.setCol(-1);

                        } else{
                            throw new IllegalMove("Iilegal move ");
                        }
                    }
                }
            } else{
                throw new IllegalMove("Worng color");
            }
        } else{
            throw new RuntimeException("Not correct");
        }
    }
}
