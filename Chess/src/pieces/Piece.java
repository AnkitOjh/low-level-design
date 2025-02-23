package pieces;

import chess.Board;
import chess.Color;

public abstract class Piece {
    private final Color color;
    private int row;
    private int col;

    public Piece(Color color, int row, int col){
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public abstract boolean canMove(Board board, int destRow, int distCol);

    public Color getColor(){
        return this.color;
    }

    public int getRow(){
        return this.row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getCol(){
        return this.col;
    }

}
