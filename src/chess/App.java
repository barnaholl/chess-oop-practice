package chess;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Game game=new Game();
        while(true){
            int[] coordinates=game.getInput();
            game.step(coordinates);
        }

    }
}
