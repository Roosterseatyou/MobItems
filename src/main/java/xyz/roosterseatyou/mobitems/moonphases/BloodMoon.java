package xyz.roosterseatyou.mobitems.moonphases;

public class BloodMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BloodMoon(int stage, boolean stopping) {
        super(stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public BloodMoon(int stage){
        super(stage);
    }

    public static int getServerChance() {
        return chance;
    }

    public static void setServerChance(int chance) {
        BloodMoon.chance = chance;
    }

    public static boolean isServerActive() {
        return active;
    }

    public static void setServerActive(boolean active) {
        BloodMoon.active = active;
    }

    @Override
    public String toString() {
        return "Stage " + getStage() + " Blood Moon.";
    }
}
