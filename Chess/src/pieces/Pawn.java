package pieces;

import chess.Board;
import chess.Color;

public class Pawn extends Piece{
    public Pawn(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int distCol) {
        if((Math.abs(destRow - getRow()) == 1 && Math.abs(getCol()-distCol) ==0) ||
                ((Math.abs(destRow - getRow()) == 1 && Math.abs(getCol()-distCol) ==1) &&
                        board.getBoard()[destRow][distCol] != null &&
                        board.getBoard()[destRow][distCol].getColor() != getColor() )){
            return true;
        }
        return false;
    }
}
