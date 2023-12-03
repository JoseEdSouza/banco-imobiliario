package app.model;

import app.interfaces.IHouse;

public class Share implements IHouse{

    public String name;
    public int buyValue;
    public int shareValue;
    public int playerId;

    public Share(String name, int buyValue, int shareValue) {
        this.name = name;
        this.buyValue = buyValue;
        this.shareValue = shareValue;
        this.playerId = 0;
    }

    public String getName() {
        return name;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int calculateProfit(int diceValue){
        return this.shareValue * diceValue;
    }

    @Override
    public void takeAction(Player player) {
        if(getPlayerId() == 0){
            player.buyShare(this);
            setPlayerId(player.getId());
        }
        else {
            if(getPlayerId() != player.getId()){
            }
        }
    }

    @Override
    public String toString() {
        return "Share{" +
                "name='" + name + '\'' +
                ", shareValue=" + shareValue +
                ", playerId=" + playerId +
                '}';
    }
}