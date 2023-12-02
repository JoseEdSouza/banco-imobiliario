package app.model;

import app.interfaces.House;

public class GainEvent implements House {

    public void takeAction(Player player){
        player.receive(200000);
    }

    public String toString() {
        return "Restituição de Imposto do Imposto de Renda. Ganhe R$ 200.000,00";
    }
}
