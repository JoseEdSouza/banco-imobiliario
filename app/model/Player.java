package app.model;

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

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public void payPlayer(int value, Player receiver) {
        if (value >= this.balance) {
            this.balance = 0;
            receiver.receive(this.balance);
            notifica();
        } else {
            this.balance -= value;
            receiver.receive(value);
        }
    }

    public void pay(int value) {
        this.balance -= value;
        if (this.balance <= 0){
            notifica();
        }
    }

    public void receive(int value) {
        this.balance += value;
    }

    public void buyProperty(Property p) {
        if (this.balance < p.rentalValue()){
            System.out.println("Sem dinheiro o suficiente.");
        }
        else{
            p.setIdPlayer(this.id);
            this.balance -= p.rentalValue();
        }
    }

    public void skipTurn(){
        setSkip(this.skip++);
    }

    public void notifica(){

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