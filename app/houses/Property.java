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
    private int idPlayer;
    private Level level;
    private final Type type;

    public Property(String name, int buyValue, int rentBase, int upgradeValue, Type type){
        this.name = name;
        this.buyValue = buyValue;
        this.rentBase = rentBase;
        this.upgradeValue = upgradeValue;
        this.idPlayer = 0;
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

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int rentalValue(){
        return (rentBase * type.type * level.level);
    }

    public String toString() {
        return  "\n\nName = " + name +
                "\nUpgradeValue = " + upgradeValue +
                "\nidPlayer = " + idPlayer;
    }

    @Override
    public void takeAction(Player player) {
        if(getIdPlayer() == 0){
            player.buyProperty(this);
            setIdPlayer(player.getId());
        }
    }
}
