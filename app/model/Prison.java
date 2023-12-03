package app.model;

import java.util.ArrayList;
import java.util.List;

public class Prison extends BoardHouse{
    public Prison(){}
    @Override
    public void takeAction(Player player) {
        player.setSkip(3);
    }

    @Override
    public String toString() {
        return "Fique ";
    }
}
