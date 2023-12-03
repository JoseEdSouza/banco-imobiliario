package app.model;

import app.houses.Property;
import app.houses.Share;

public class Player {
    private static int actualId = 0;
    private final int id;
    private final String name;
    private int balance;
    private int skip;


    public Player(String name) {
        this.name = name;
        this.id = actualId + 1 ;
        this.skip = 0;
        this.balance = 0;
        actualId++;
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
            p.setIdPlayer(this.id);
            this.balance -= p.getBuyValue();
        }
    }

    public void buyShare(Share s) {
        if (this.balance < s.getBuyValue()){
            System.out.println("Sem dinheiro o suficiente.");
        }
        else{
            s.setPlayerId(this.id);
            this.balance -= s.getBuyValue();
        }
    }

    public void notifies(){}

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
}