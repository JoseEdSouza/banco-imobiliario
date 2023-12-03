package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class LuckyOrSetback implements IHouse {
    LuckOrSetBackFactory factory = new LuckOrSetBackFactory();
    private Random random;
    private int valueRandom;

    public LuckyOrSetback(){
        this.random = new Random();
        valueRandom = (int) (Math.random()*30)+1;
        factory.createMessage();
        factory.createValues();
    }

    @Override
    public String getName() {
        return "Sorte/Revés";
    }

    public void takeAction(Player player) {
        if(valueRandom%2 != 0){
            player.receive(factory.getValues().get(valueRandom-1));
        } else{
            player.pay(factory.getValues().get(valueRandom-1));
        }

    }

    public String toString() {
        return factory.getMessage().get(valueRandom-1);
    }
}
