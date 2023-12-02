package app.model;

import app.interfaces.House;

public class LostEvent implements House {

    public void takeAction(Player player) {
        player.pay(200000);
    }

    public String toString() {
        return "Receita federal. Pague R$ 200.000,00";
    }
}
