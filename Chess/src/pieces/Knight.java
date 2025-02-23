package pieces;

import chess.Board;
import chess.Color;

public class Knight extends Piece{

    public Knight(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int distCol) {
        if((Math.abs(destRow - getRow()) == 2 && Math.abs(getCol()-distCol) ==1) ||
                (Math.abs(destRow - getRow()) == 1 && Math.abs(getCol()-distCol) ==2)){
            return true;
        }
        return false;
    }
}
