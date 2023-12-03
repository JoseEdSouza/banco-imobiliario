package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

import java.util.Random;

public class LuckyOrSetback implements IHouse {

    private Random random;
    private final String name;
    public LuckyOrSetback(String name){
        this.random = new Random();
        this.name = name;
    }
    @Override
    public String getName() {
        if(random.nextInt() % 2 == 0){
            return "Sorte";
        }
        return "Revés";
    }

    public void takeAction(Player player) {
    }

    public String toString() {
        return "";
    }
}
