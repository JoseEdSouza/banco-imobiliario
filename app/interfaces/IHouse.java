package app.interfaces;

import app.model.Player;

public abstract class IHouse {
    public abstract String getName();
    // TODO - encapsular verificação no takeAction()
    public abstract void takeAction(Player player);
    public abstract void applyGain(Player player);
    public abstract void apllyMiss(Player player);
    public abstract boolean isHoliday();
    public abstract boolean isPrison();
    public abstract void setSkipTurn(Player player);
    public abstract void applyLuckyOrUnluck(Player player);
    public abstract String toString();
}
