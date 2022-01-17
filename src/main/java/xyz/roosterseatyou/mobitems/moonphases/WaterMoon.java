package xyz.roosterseatyou.mobitems.moonphases;

public class WaterMoon extends MoonPhase{
    private static int chance = 0;
    private static boolean active = false;

    public WaterMoon(int stage, boolean stopping){
        super(stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public WaterMoon(int stage) {
        super(stage);
    }


    public static boolean isServerActive() {
        return active;
    }

    public static void setServerActive(boolean active) {
        WaterMoon.active = active;
    }

    public static int getServerChance() {
        return chance;
    }

    public static void setServerChance(int chance) {
        WaterMoon.chance = chance;
    }
}
