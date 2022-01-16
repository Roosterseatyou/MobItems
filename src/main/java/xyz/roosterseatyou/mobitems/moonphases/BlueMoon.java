package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class BlueMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BlueMoon(int stage, boolean stopping) {
        super(stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public BlueMoon(int stage){
        super(stage);
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
