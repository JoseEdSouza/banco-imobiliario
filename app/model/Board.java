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

    public void addHouse(IHouse house){
        this.houses.add(house);
    }

    public void addPlayer(Player player){
        this.playerPosition.put(player.getId(), 0);
    }

    public void updatePosition(int position, Player player){
        int playerId = player.getId();
        int currentPosition = playerPosition.get(playerId);
        if (currentPosition + position >= houses.size()){
            playerPosition.replace(playerId, position - houses.size());
        }
        playerPosition.replace(playerId, position);
    }

    // TODO - make this get name from house
    @Override
    public String toString() {
        String result = "";
        for(IHouse house : houses){
            String aux = "";
            for(int i=0; i<playerPosition.size(); i ++){
                if(houses.indexOf(house) == playerPosition.get(i+1)){
                    aux += (i + 1) + " ";
                }
            }
            result += "\n" + house.getName() + ": " + aux;
        }
        return result;
    }
}
