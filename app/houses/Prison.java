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

    }

    @Override
    public String toString() {
        return null;
    }
}
