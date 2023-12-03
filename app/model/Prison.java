package app.model;

import app.interfaces.IHouse;

public class Prison extends IHouse {
    public Prison(){}
    @Override
    public boolean isPrison() {
        return true;
    }

    @Override
    public void setSkipTurn(int i, Player player) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void takeAction(Player player) {}

    @Override
    public void applyGain(Player player) {}

    @Override
    public void apllyMiss(Player player) {}

    @Override
    public boolean isHoliday() {
        return false;
    }
    @Override
    public void applyLuckyOrUnluck(Player player) {}

    @Override
    public String toString() {
        return null;
    }
}
