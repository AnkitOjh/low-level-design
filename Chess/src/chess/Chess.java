package chess;

import exception.IllegalMove;
import pieces.Piece;

import java.util.HashMap;

public class Chess {
    private final Board board;

    private HashMap<Color, Player> hashMap;

    private Color presentColor;

    public Chess(){
        board = new Board();
        hashMap = new HashMap<>();
        presentColor = Color.WHITE;
    }

    public void addPlayer(Player player,Player player1){
        hashMap.put(Color.WHITE,player);
        hashMap.put(Color.BLACK,player1);
    }

    public void makeMove(Piece piece,int row,int col,int distRow, int distCol,Player player){
        if(hashMap.get(presentColor).equals(player)){
            board.move(piece.getRow(), piece.getCol(),distRow,distCol,piece.getColor());
            if(presentColor.equals(Color.WHITE)){
                presentColor = Color.BLACK;
            } else{
                presentColor = Color.WHITE;
            }
        } else{
            throw new IllegalMove("Illegal player");
        }
    }


}
