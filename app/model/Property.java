package app.model;

import app.interfaces.IHouse;
import app.utils.Level;
import app.utils.Type;

public class Property extends IHouse {
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
        else{
            if(getIdPlayer() == player.getId()){
                this.level = this.level.NextLevel();
                player.pay(getUpgradeValue());
            }
            else {
            }
        }
    }

    @Override
    public void applyGain(Player player) {

    }

    @Override
    public void apllyMiss(Player player) {

    }

    @Override
    public boolean isHoliday() {
        return false;
    }

    @Override
    public boolean isPrison() {
        return false;
    }

    @Override
    public void setSkipTurn(Player player) {

    }

    @Override
    public void applyLuckyOrUnluck(Player player) {

    }
}
