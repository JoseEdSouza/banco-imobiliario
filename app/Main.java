package app;

import app.houses.Property;
import app.interfaces.IHouse;
import app.model.Board;
import app.model.Game;
import app.model.Player;
import app.utils.Type;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board board = Board.getInstance();

        Property propriedade1 = new Property("Rua tananan", 1000, 500, 1000, Type.MEDIUM);
        Property propriedade2 = new Property("Rua pimbas", 800, 600, 200, Type.BASIC);
        Property propriedade3 = new Property("Rua champolas", 800, 600, 200, Type.BASIC);

        board.addHouse(propriedade1);
        board.addHouse(propriedade2);
        board.addHouse(propriedade3);

        Game game = new Game();

        game.addPlayer();

        System.out.println(game.getBoard().toString());
    }
}
