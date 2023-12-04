package app.model;

import app.controller.InputController;
import app.houses.Property;
import app.interfaces.IHouse;
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

    private Player getPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
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
        for (Map.Entry e : list) {
            auxArray.add(getPlayerById((Integer) e.getKey()));
            getBoard().addPlayer(Objects.requireNonNull(getPlayerById((Integer) e.getKey())));
        }
        players = auxArray;
        playerAction();
    }

    public void playerAction() {
        while (true){
            for (Player player : players){
                screen.flush()
                        .setContent(getBoard().toString())
                        .setOptions(getOptions(getBoard().houses.get(getBoard().getPosition(player.getId()))))
                        .setInfo("\nÉ a vez do jogador " + player.getName())
                        .update();
                break;
            }
            break;
        }
    }

    public String getOptions(IHouse house){
        return switch (house.getTypeHouse()) {
            case 1 -> "\nOpções[ comprar propriedade, ver propridade, pular turno]";
            case 2 -> "\nOpções[ comprar ação, ver ação, pular turno]";
            case 3, 4, 5, 6, 7, 8 -> "\nOpções[]";
            default -> throw new IllegalStateException("Unexpected value: " + house.getTypeHouse());
        };
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
