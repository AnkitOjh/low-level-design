import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game();
        game.createPlayer("Ankit");
        game.createPlayer("sonu");
        game.move("Ankit");
        game.move("Ankit");
    }
}