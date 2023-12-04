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
        while (isGameOver()){
            String input = "";
            int auxDice = 0;
            int auxInt = 0;
            for (Player player : players){

                screen.flush()
                        .setContent(getBoard().toString())
                        .setOptions("\nOpções[Lançar Dados]")
                        .setInfo("\nÉ a vez do jogador " + player.getName() + ", lançe os dados (escreva lançar)")
                        .update();

                input = inputController.scan().toString();
                auxDice = rollDice();

                System.out.println("\nO jogador " + player.getName() + " andou " + auxDice + " casas");
                getBoard().updatePosition(auxDice, player);

                IHouse actualHouse = getBoard().houses.get(getBoard().getPosition(player.getId()));

                screen.flush()
                        .setContent("O jogador " + player.getName() +" caiu em " + actualHouse.getName())
                        .setOptions(getOptions(actualHouse))
                        .update();

                while (true){
                    input = "";
                    screen.setInfo("\nO jogador " + player.getName() + ", deseja realizar alguma ação ?");
                    input = inputController.scan().toString();
                    auxInt = inputController.scan().toInt(input);

                    if(actualHouse.getTypeHouse() == 1 || actualHouse.getTypeHouse() == 2){
                        if(input.equals("1") || input.equals("3")){
                            takeAction(actualHouse,player, auxInt);
                            break;
                        }
                        else{
                            takeAction(actualHouse,player, auxInt);
                        }
                    }
                    else if(actualHouse.getTypeHouse() > 2 || actualHouse.getTypeHouse() < 8){
                        if(input.equals("4")){
                            takeAction(actualHouse,player, auxInt);
                        }
                        else{
                            takeAction(actualHouse,player, auxInt);
                            break;
                        }
                    }
                    else {
                        takeAction(actualHouse,player, auxInt);
                        break;
                    }
                }
            }
        }
        screen.setContent("O jogador " + players.get(0).getName() + " vanceu!!!");
    }

    public String getOptions(IHouse house){
        return switch (house.getTypeHouse()) {
            case 1 -> "Opções[ comprar propriedade(clique 1), ver propridade(clique 2), pular turno(clique 3), ver saldo(clique 4)]";
            case 2 -> "Opções[ comprar ação(clique 1), ver ação(clique 2), pular turno(clique 3), ver saldo(clique 4)]";
            case 3, 4, 5, 6, 7, 8 -> "Opções[pular turno(clique 3), ver saldo(clique 4)]";
            default -> throw new IllegalStateException("Unexpected value: " + house.getTypeHouse());
        };
    }

    public void takeAction(IHouse house, Player player, int choice) {
        String message = "";
        if (house.getTypeHouse() == 1) {
            if (choice == 1) {
                house.takeAction(player);
                message = ("O jogador " + player.getName() + " comprou a propriedade " + house.getName());
            } else if (choice == 2) {
                message = (house.toString());
            } else if (choice == 3) {
                player.setSkip(player.getSkip() + 1);
                message = ("O jogador " + player.getName() + " passou a vez");
            } else if (choice == 4) {
                message = String.valueOf((player.getBalance()));
            } else {
                message = ("Comando inválido");
            }
        } else if (house.getTypeHouse() == 2) {
            if (choice == 1) {
                house.takeAction(player);
                message = ("O jogador " + player.getName() + " comprou a ação " + house.getName());
            } else if (choice == 2) {
                message = (house.toString());
            } else if (choice == 3) {
                player.setSkip(player.getSkip() + 1);
                message = ("O jogador " + player.getName() + " passou a vez");
            } else if (choice == 4) {
                message = ("Saldo atual: " + player.getBalance());
            } else {
                message = ("Comando inválido");
            }
        } else if (house.getTypeHouse() > 2 || house.getTypeHouse() < 8) {
            house.takeAction(player);
            message = (house.toString());

            if (choice == 4) {
                message = ("Saldo atual: " + player.getBalance());
            }
        }
        else{
            house.takeAction(player);
            message = (house.toString());
        }
        screen.setInfo(message).update();
    }

    public boolean isGameOver(){
        return players.size() != 1;
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
