package app.model;

import app.interfaces.ObservedGame;
import app.interfaces.ScreenObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements ObservedGame {
    private List<ScreenObserver> observers = new List;
    ArrayList<Player>players;
    Board board;

    public Game(){
        this.players = new ArrayList<Player>();
        this.board = null;
    }
    public void starts(Board board){
        this.board = Board.getInstance();
    }

    public int RollDice(){
        Random random = new Random();
        return random.randint(2, 12);
    }

    @Override
    public void addObserver(ScreenObserver screenObserver) {

    }

    @Override
    public void removeObserver(ScreenObserver screenObserver) {

    }

    @Override
    public void notifies() {

    }
}
