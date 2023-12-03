package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

public class LostEvent implements IHouse {

    public LostEvent(){

    }

    @Override
    public String getName() {
        return "Perca";
    }

    public void takeAction(Player player) {
        player.pay(200000);
    }

    public String toString() {
        return "Receita federal. Pague R$ 200.000,00";
    }
}
