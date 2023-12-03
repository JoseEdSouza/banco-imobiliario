package app.model;

import app.interfaces.ObservedGame;
import app.interfaces.ScreenObserver;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game implements ObservedGame {
    private ArrayList<ScreenObserver> observers;
    private final Board board = Board.getInstance();
    private final ArrayList<Player> playersTurns;
    private final Screen screen = new Screen();

    public Game() {
        this.observers = new ArrayList<ScreenObserver>();
        this.playersTurns = new ArrayList<Player>();
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Player> getPlayersTurns() {
        return playersTurns;
    }

    public void addPlayersTurns(Player player) {
        this.playersTurns.add(player);
    }

    public void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int playerCount = 1;
        while (playerCount < 6) {
            screen.flush();
            screen.setContent("Adicionar um Jogador ? (s/n)");
            screen.update();
            input = scanner.nextLine();

            if (input.equals("s")) {
                screen.flush();
                screen.setContent("Escolha um nome para o jogador " + playerCount);
                screen.update();
                input = scanner.nextLine();

                Player player = new Player(input);


                System.out.println("Jogador " + player.getName() + " criado");

                board.addPlayer(player);
                addPlayersTurns(player);
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
        int auxDice = 0;
        ArrayList<Player> playersActualTurn = new ArrayList<Player>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < playersTurns.size(); i++) {
            System.out.println("Jogador " + playersTurns.get(i) + ", deseja lançar os dados para decidir a sua vez de jogar ? (s/n)");

        }
    }

    public void playerAction() {

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
