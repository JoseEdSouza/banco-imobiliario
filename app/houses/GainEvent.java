package app.houses;


import app.interfaces.IHouse;
import app.model.Player;

public class GainEvent implements IHouse {

    public String name;
    public GainEvent(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void takeAction(Player player)
    {
        player.receive(200000);
    }

    @Override
    public int getTypeHouse() {
        return 3;
    }

    public String toString() {
        return "Restituição de Imposto do Imposto de Renda. Ganhe R$ 200.000,00";
    }
}
