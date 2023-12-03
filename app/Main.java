package app;

import app.houses.LuckyOrSetback;
import app.model.Player;

public class Main {
    public static void main(String[] args) {
        LuckyOrSetback luck = new LuckyOrSetback();
        Player p = new Player("teste");
        luck.takeAction(p);
        System.out.println(luck.toString());
        System.out.println(p.toString());
    }

}
