package xyz.roosterseatyou.mobitems.moonphases;

public class WaterMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public WaterMoon(boolean stopping){
        super(stopping);
        if(stopping){
            setServerActive(false);
        }
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
