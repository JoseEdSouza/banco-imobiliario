package app.houses;

import app.interfaces.IHouse;
import java.util.ArrayList;

public class LuckOrSetBackFactory{
    private final ArrayList<IHouse> cards = new ArrayList<IHouse>();
    public void createCard(){
        cards.add(new LuckyOrSetback());
    }
    public ArrayList<IHouse> getCards(){
        return cards;
    }

}
