package app.model;

import app.houses.Property;
import app.houses.Share;
import app.interfaces.IGameObserver;
import app.interfaces.IObservedPlayer;

public class Player implements IObservedPlayer {
    private Game gameObserver;
    private static int actualId = 1;
    private final int id;
    private final String name;
    private int balance;
    private int skip;


    public Player(String name) {
        this.name = name;
        this.id = actualId ++;
        this.skip = 0;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    public int getSkip() {
        return this.skip;
    }
    public void setSkip(int value){this.skip = value;}

    public void payPlayer(int value, Player receiver) {
        if (value >= this.balance) {
            this.balance = 0;
            receiver.receive(this.balance);
            notifies();
        } else {
            this.balance -= value;
            receiver.receive(value);
        }
    }

    public void pay(int value) {
        this.balance -= value;
        if (this.balance <= 0){
            notifies();
        }
    }

    public void receive(int value) {
        this.balance += value;
    }

    public void buyProperty(Property p) {
        if (this.balance < p.getBuyValue()){
            System.out.println("Sem dinheiro o suficiente.");
        }
        else{
            p.setOwner(this);
            this.balance -= p.getBuyValue();
        }
    }

    public void buyShare(Share s) {
        if (this.balance < s.getBuyValue()){
            System.out.println("Sem dinheiro o suficiente.");
        }
        else{
            s.setOwner(this);
            this.balance -= s.getBuyValue();
        }
    }
    public void skipTurn(int n){
        this.setSkip(n);
    }

    @Override
    public String toString() {
        return "Player { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", skip=" + skip +
                " }";
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void notifies() {
        gameObserver.updateState(this);
    }
}