package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

import java.util.Random;

public class LuckyOrSetback implements IHouse {

    private Random random;

    public LuckyOrSetback(){
        this.random = new Random();
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
