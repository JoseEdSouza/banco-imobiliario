package app.model;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    ArrayList<Player>players;
    Board board;

    public Game(){
        this.players = new ArrayList<Player>();
        this.board = null;
    }
    public void starts(Board board){
        this.board = board.getInstance();
    }

    public int RollDice(){
        Random random = new Random();
        return random.randint(2, 12);
    }
}
