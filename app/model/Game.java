package app.model;

import app.interfaces.ObservedGame;
import app.interfaces.ScreenObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    ArrayList<Player>players;
    Board board;
    // TODO - instancia Screen: implementar função
    public Game(){
        this.players = new ArrayList<Player>();
        this.board = null;
    }

    public void starts(Board board){
        this.board = Board.getInstance();
    }

    public int RollDice(){
        Random random = new Random();
        return random.nextInt(2, 12);
    }
}
