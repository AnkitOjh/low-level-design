import Entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    private List<Player> playerList;

    private Player currentPlayer;
    private int currentIndex;

    private boolean gameStart = false;


    public Game(){
        this.board = new Board();
        playerList = new ArrayList<>();
    }

    public void createPlayer(String userName){

        if(!gameStart){
            Player player = new Player(userName);
            player.setPosition(new int[]{1,0});
            playerList.add(player);
            currentPlayer = playerList.get(0);
            this.currentIndex = 0;
        }
        else{
            throw new RuntimeException("Game has started can't add new player");
        }

    }

    public void move(String userName){
        Player player = null;
        for(Player player1 : playerList){
            if(player1.getUserName().equalsIgnoreCase(userName)){
                player = player1;
            }
        }
        if(player == null){
            System.out.println("No player is there with this userName "+ userName);
            return;
        }
        int dice;
        if(player == currentPlayer){
            this.gameStart = true;
            dice = throwDice();
            int[] destination = board.giveTheDestination(dice,player.getPosition());
            if(destination[0]==0 && destination[1]==10){
                throw new RuntimeException("Winner is "+player.getUserName());
            }
            player.setPosition(destination);
            System.out.println("Player "+player.getUserName()+
                    " has moved to "+ player.getPosition()[0]+" "+player.getPosition()[1]);
            if(dice != 6){
                currentIndex+=1;
                currentIndex = currentIndex%6;
                currentPlayer = playerList.get(currentIndex);
            }
            else{
                System.out.println("Please do ur turn again "+currentPlayer.getUserName());
            }
        }
        else{
            System.out.println("Its not ur turn");
            System.out.println("Please do ur turn "+currentPlayer.getUserName());
        }
    }

    private int throwDice(){
        return 3;
//        return (int) (Math.random() * 6) + 1;
    }
}
