package chess;


import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        Game game=new Game();
        while(true){
            System.out.println(game.getRound()+" player give input:");
            int[] coordinates=game.getInput();
            game.step(coordinates);
            if(game.getRound()==Color.WHITE){
                game.setRound(Color.BLACK);
            }
            else{
                game.setRound(Color.WHITE);
            }
        }


    }
}
