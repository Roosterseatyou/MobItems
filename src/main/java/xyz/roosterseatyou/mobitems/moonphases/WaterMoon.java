package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class WaterMoon extends MoonPhase{
    private static int chance = 0;
    private static boolean active = false;

    public WaterMoon(Plugin plugin, int stage, boolean stopping){
        super(plugin, stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public WaterMoon(Plugin plugin, int stage) {
        super(plugin, stage);
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
