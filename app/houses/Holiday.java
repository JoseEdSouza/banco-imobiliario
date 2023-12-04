package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

public class Holiday implements IHouse {

    public Holiday(){}
    @Override
    public String getName() {
        return "Feriado";
    }

    @Override
    public void takeAction(Player player) {
        player.setSkip(1);
    }

    @Override
    public int getTypeHouse() {
        return 6;
    }

    @Override
    public String toString(){
        return "Hoje é Feriado. Aproveite para descansar.";
    }
}
