package app.houses;


import app.interfaces.IHouse;
import app.model.Player;

public class GainEvent implements IHouse {

    public GainEvent(){

    }

    @Override
    public String getName() {
        return "Ganho";
    }

    public void takeAction(Player player)
    {
        player.receive(200000);
    }

    public String toString() {
        return "Restituição de Imposto do Imposto de Renda. Ganhe R$ 200.000,00";
    }
}
