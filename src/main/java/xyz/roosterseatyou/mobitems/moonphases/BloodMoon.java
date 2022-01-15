package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class BloodMoon extends MoonPhase{
    private static int chance = 0;
    private static boolean active = false;

    public BloodMoon(Plugin plugin) {
        super(plugin);
    }

    public static int getChance() {
        return chance;
    }

    public static void setChance(int chance) {
        BloodMoon.chance = chance;
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        BloodMoon.active = active;

    }
}
