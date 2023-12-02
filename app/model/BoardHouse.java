package app.model;

import app.interfaces.House;

public abstract class BoardHouse implements House {

    public abstract void takeAction(Player player);
    public abstract String toString();
}
