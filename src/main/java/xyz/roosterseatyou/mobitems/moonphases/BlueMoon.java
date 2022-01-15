package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class BlueMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BlueMoon(Plugin plugin) {
        super(plugin);
    }

    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        BlueMoon.chance = chance;
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        BlueMoon.active = active;
    }
}
