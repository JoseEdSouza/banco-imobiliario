package app.interfaces;

import app.model.Player;

public interface IHouse {
    public String getName();
    public void takeAction(Player player);
    public int getTypeHouse();
    public String toString();
}
