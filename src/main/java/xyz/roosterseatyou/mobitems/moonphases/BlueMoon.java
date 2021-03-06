package xyz.roosterseatyou.mobitems.moonphases;

public class BlueMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BlueMoon(boolean stopping) {
        super(stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public static int getServerChance() {
        return chance;
    }

    public static void setServerChance(int chance) {
        BlueMoon.chance = chance;
    }

    public static boolean isServerActive() {
        return active;
    }

    public static void setServerActive(boolean active) {
        BlueMoon.active = active;
    }
}
