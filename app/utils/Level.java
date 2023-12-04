package app.utils;

public enum Level {
    BASIC(1),
    HIGH_BASIC(2),
    MEDIUM(3),
    HIGH_MEDIUM(4),
    ADVANCED(5);

    public final int level;

    Level(int level){
        this.level = level;
    }

    public Level NextLevel(){
        if(this == Level.ADVANCED)
            return Level.ADVANCED;
        return Level.values()[this.level];
    }
}