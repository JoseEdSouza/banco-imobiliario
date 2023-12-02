package app.model;

import app.interfaces.House;
import app.utils.Level;
import app.utils.Type;

public class Property extends BoardHouse {
    private String name;
    private int rentBase;
    private int upgradeValue;
    private int idPlayer;
    private Level level;
    private final Type type;

    public Property(String name, int rentBase, int upgradeValue, Type type){
        this.name = name;
        this.rentBase = rentBase;
        this.upgradeValue = upgradeValue;
        this.idPlayer = 0;
        this.type = type;
        level = Level.BASIC;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setRentBase(int rentBase) {
        this.rentBase = rentBase;
    }

    public void setUpgradeValue(int upgradeValue) {
        this.upgradeValue = upgradeValue;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void updateLevel(){
        level = level.NextLevel();
    }

    public int rentalValue(){
        return (rentBase * type.type * level.level);
    }

    @Override
    public void takeAction(Player player) {

    }

    public String toString() {
        return  "\n\nName = " + name +
                "\nUpgradeValue = " + upgradeValue +
                "\nidPlayer = " + idPlayer;
    }
}
