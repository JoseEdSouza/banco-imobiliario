package app.houses;

import app.interfaces.IHouse;
import app.model.Player;

public class Share implements IHouse{

    public String name;
    public int buyValue;
    public int shareValue;
    public Player owner;

    public Share(String name, int buyValue, int shareValue) {
        this.name = name;
        this.buyValue = buyValue;
        this.shareValue = shareValue;
        this.owner = null;
    }

    public String getName() {
        return name;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public int calculateProfit(int diceValue){
        return this.shareValue * diceValue;
    }

    @Override
    public void takeAction(Player player) {
        if(getOwner() == null) {
            player.buyShare(this);
            setOwner(player);
        }
    }

    @Override
    public int getTypeHouse() {
        return 2;
    }

    @Override
    public String toString() {
        return "\n\nName = " + name +
                "\nUpgradeValue = " + shareValue +
                "\nidPlayer = " + owner;
    }
}