package xyz.roosterseatyou.mobitems.moonphases;

public class GoldenMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public GoldenMoon(int stage, boolean stopping) {
        super(stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public GoldenMoon(int stage){
        super(stage);
    }

    public static int getServerChance() {
        return chance;
    }

    public static void setServerChance(int chance) {
        GoldenMoon.chance = chance;
    }

    public static boolean isServerActive() {
        return active;
    }

    public static void setServerActive(boolean active) {
        GoldenMoon.active = active;
    }
}
