package pieces;

import chess.Board;
import chess.Color;

public class Rook extends Piece {
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int distCol) {
        if((destRow == getRow() && getCol() != distCol) ||
                (destRow != getRow() && getCol() == distCol)){
            return true;
        }
        return false;
    }
}
