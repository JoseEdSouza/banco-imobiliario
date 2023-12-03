package app;

import app.houses.Property;
import app.interfaces.IHouse;
import app.model.Board;
import app.model.Player;
import app.utils.Type;

public class Main {
    public static void main(String[] args){
        Board board = Board.getInstance();

        Property propriedade1 = new Property("Rua tananan", 1000, 500, 1000, Type.MEDIUM);
        Property propriedade2 = new Property("Rua pimbas", 800, 600, 200, Type.BASIC);
        Property propriedade3 = new Property("Rua champolas", 800, 600, 200, Type.BASIC);

        board.addHouse(propriedade1);
        board.addHouse(propriedade2);
        board.addHouse(propriedade3);

        Player player = new Player("Erick");
        Player player2 = new Player("Ericcles");

        board.addPlayer(player);
        board.addPlayer(player2);

        board.updatePosition(2, player);
        board.updatePosition(2, player2);

        System.out.println(board.toString());
    }
}
