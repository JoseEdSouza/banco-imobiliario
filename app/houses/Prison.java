package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

public class Prison implements IHouse {
    public Prison(){}

    @Override
    public String getName() {
        return "Camburão";
    }

    @Override
    public void takeAction(Player player) {
        player.setSkip(3);
    }

    @Override
    public int getTypeHouse() {
        return 8;
    }

    @Override
    public String toString() {
        return null;
    }
}
