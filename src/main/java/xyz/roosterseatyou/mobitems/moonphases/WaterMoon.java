package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class WaterMoon extends MoonPhase{
    private static int chance = 0;
    private static boolean active = false;

    public WaterMoon(Plugin plugin, int stage, boolean stopping){
        super(plugin, stage, stopping);
    }

    public WaterMoon(Plugin plugin, int stage) {
        super(plugin, stage);
    }


    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        WaterMoon.active = active;
    }

    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        WaterMoon.chance = chance;
    }
}
