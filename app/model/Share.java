package app.model;

public class Share {
    public String name;
    public int shareValue;
    public int playerId = 0;
    public Share(String name, int shareValue) {
        this.name = name;
        this.shareValue = shareValue;
    }
    public int calculateProfit(int diceValue){
        return this.shareValue * diceValue;
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