package app.houses;

import app.interfaces.IHouse;
import app.model.Player;
import app.utils.Level;
import app.utils.Type;

public class Property implements IHouse {
    private final String name;
    private final int buyValue;
    private final int rentBase;
    private final int upgradeValue;
    private Player owner;
    private Level level;
    private final Type type;

    public Property(String name, int buyValue, int rentBase, int upgradeValue, Type type){
        this.name = name;
        this.buyValue = buyValue;
        this.rentBase = rentBase;
        this.upgradeValue = upgradeValue;
        this.owner = null;
        this.type = type;
        level = Level.BASIC;
    }

    public String getName() {
        return name;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public int getRentBase() {
        return rentBase;
    }

    public int getUpgradeValue() {
        return upgradeValue;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public int rentalValue(){
        return (rentBase * type.type * level.level);
    }

    public String toString() {
        return  "\n\nName = " + name +
                "\nUpgradeValue = " + upgradeValue +
                "\nidPlayer = " + owner;
    }

    @Override
    public void takeAction(Player player) {
        if(getOwner() == null){
            player.buyProperty(this);
            setOwner(player);
        } else if (this.owner != player){
            player.payPlayer(this.rentalValue(), owner);
        } else {
            level = level.NextLevel();
        }
    }

    @Override
    public int getTypeHouse() {
        return 1;
    }
}
