package app.interfaces;

import app.model.Screen;

public interface ObservedGame {
    public void addObserver(ScreenObserver screenObserver);
    public void removeObserver(ScreenObserver screenObserver);
    public void notifies();
}
