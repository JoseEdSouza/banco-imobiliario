package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class LuckyOrSetback implements IHouse {
    private Random random;
    private int valueRandom;
    public LuckyOrSetback(){
        this.random = new Random();
        valueRandom = (int) (Math.random()*30)+1;
    }

    @Override
    public String getName() {
        return "Sorte/Revés";
    }

    public void takeAction(Player player) {
        if(valueRandom%2 ==0){

        } else{

        }

    }

    public String toString() {
        return "";
    }
}
