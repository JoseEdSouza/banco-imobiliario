package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

public class PrisonVisit implements IHouse {

    public PrisonVisit(){}

    @Override
    public String getName() {
        return "Visita à prisão";
    }

    @Override
    public void takeAction(Player player) {
        player.setSkip(1);
    }

    @Override
    public String toString(){
        return "Aproveite para visitar o seu amigo prisioneiro";
    }
}
