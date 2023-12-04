package app.interfaces;

import app.model.Player;

public interface IGameObserver {
    public void updateState(Player player);
}
