package app.interfaces;

import app.model.Player;

public abstract class IHouse {
    public abstract String getName();
    public abstract void takeAction(Player player);
    public abstract void applyGain(Player player);
    public abstract void apllyMiss(Player player);
    public abstract boolean isHoliday();
    public abstract boolean isPrison();
    public abstract void setSkipTurn(int i, Player player);
    public abstract void applyLuckyOrUnluck(Player player);
    public abstract String toString();
}
