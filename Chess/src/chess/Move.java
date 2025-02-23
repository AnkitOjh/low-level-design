package chess;

import pieces.Piece;

public class Move {
    private Piece piece;

    private int distRow;

    private int distCol;

    public Move(Piece piece,int distRow,int distCol){
        this.piece = piece;
        this.distRow = distRow;
        this.distCol = distCol;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getDistRow() {
        return distRow;
    }

    public void setDistRow(int distRow) {
        this.distRow = distRow;
    }

    public int getDistCol() {
        return distCol;
    }

    public void setDistCol(int distCol) {
        this.distCol = distCol;
    }



}
