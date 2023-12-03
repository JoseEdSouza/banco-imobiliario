package app.model;

import app.controller.InputController;
import app.houses.Property;
import app.interfaces.ObservedGame;
import app.interfaces.ScreenObserver;
import app.utils.Type;

import java.util.*;

public class Game implements ObservedGame {
    private ArrayList<ScreenObserver> observers;
    private final Board board = Board.getInstance();
    private ArrayList<Player> players = new ArrayList<Player>();
    private final InputController inputController = new InputController();
    private final Screen screen = new Screen();

    public Game() {
        this.observers = new ArrayList<>();
        addPlayer();
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Player> getPlayersTurns() {
        return players;
    }

    private Player getPlayerById(int id){
        for(Player player : players){
            if(player.getId() == id){
                return player;
            }
        }
        return null;
    }

    public void addPlayer() {
        String input = "";
        int playerCount = 1;
        while (playerCount <= 6) {
            screen.flush();
            screen.setContent("Adicionar um Jogador ? (s/n)");
            screen.update();
            input = inputController.scan().toString();

            if (input.equals("s")) {
                screen.flush();
                screen.setContent("Escolha um nome para o jogador " + playerCount);
                screen.update();
                input = inputController.scan().toString();

                Player player = new Player(input);

                System.out.println("Jogador " + player.getName() + " adicionado");

                board.addPlayer(player);
                players.add(player);
                playerCount++;
            } else {
                break;
            }
        }
        playerTurn();
    }

    public int rollDice() {
        Random random = new Random();
        return (int) (Math.random() * 11) + 2;
    }

    public void playerTurn() {
        //return string
        StringBuilder result = new StringBuilder();

        //Save new order of players turn
        HashMap<Integer, Integer> playersDice = new HashMap<>();

        for (Player playersTurn : players) {
            playersDice.put(playersTurn.getId(), rollDice());
            result.append("O jogador ")
                    .append(playersTurn.getName())
                    .append(" tirou ")
                    .append(playersDice.get(playersTurn.getId()))
                    .append("\n");
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(playersDice.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        screen.flush()
                .setContent(result.toString())
                .update();

        ArrayList<Player> auxArray = new ArrayList<>();
        for(Map.Entry e : list){
            auxArray.add(getPlayerById((Integer) e.getKey()));
        }
        players = auxArray;
        playerAction();
    }

    public void playerAction() {
        Property propriedade1 = new Property("Rua tananan", 1000, 500, 1000, Type.MEDIUM);
        Property propriedade2 = new Property("Rua pimbas", 800, 600, 200, Type.BASIC);
        Property propriedade3 = new Property("Rua champolas", 800, 600, 200, Type.BASIC);

        getBoard().addHouse(propriedade1);
        getBoard().addHouse(propriedade2);
        getBoard().addHouse(propriedade3);
            screen.flush().setContent(getBoard().toString()).update();
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
