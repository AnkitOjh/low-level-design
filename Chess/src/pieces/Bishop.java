package pieces;

import chess.Board;
import chess.Color;

public class Bishop extends Piece{


    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board,int destRow, int distCol) {
        if(Math.abs(destRow - getRow()) == Math.abs(distCol - getCol())){
            return true;
        }
        return false;
    }
}
