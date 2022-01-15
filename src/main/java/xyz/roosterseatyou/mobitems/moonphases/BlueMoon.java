package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class BlueMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BlueMoon(Plugin plugin, int stage, boolean stopping) {
        super(plugin, stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public BlueMoon(Plugin plugin, int stage){
        super(plugin, stage);
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