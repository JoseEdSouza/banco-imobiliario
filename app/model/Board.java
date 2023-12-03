package app.model;

import app.interfaces.IHouse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private static Board instance  = null;
    public ArrayList<IHouse> houses;
    public Map<Integer, Integer> playerPosition;
    private Board(){
        this.houses = new ArrayList<IHouse>();
        this.playerPosition = new HashMap<Integer, Integer>();
    };

    public static Board getInstance(){
        if(instance == null){
            instance = new Board();
            return instance;
        }
        return Board.instance;
    }
    public void updatePosition(int position, Player player){
        int playerId = player.getId();
        int currentPosition = playerPosition.get(playerId);
        if (currentPosition + position >= 40){
            playerPosition.replace(playerId, position - 40);
        }
        playerPosition.replace(playerId, position);
    }

    // TODO - make this get name from house
    @Override
    public String toString() {
        String aux = "";
        // TODO - inverter verificação houses -> playerID
        for (IHouse e: houses) {
            for(int i=0; i<playerPosition.size(); i++){
                if (!playerPosition.containsKey(i)) {
                    playerPosition.put(i, 0);
                }
                if(houses.indexOf(e) == playerPosition.get(i)){
                    aux += e.getName() + " : " + i + "\n";
                }


            }
        }
        return aux;
        // casa 1: 1
        // casa 1: 2
        // casa 2: 0
        // casa 3: 0
    }
}
