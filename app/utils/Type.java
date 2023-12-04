package app.utils;

public enum Type {
    BASIC(1), HIGH_BASIC(2), MEDIUM(3), HIGH_MEDIUM(4), ADVANCED(5);

    public final int type;

    Type(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
