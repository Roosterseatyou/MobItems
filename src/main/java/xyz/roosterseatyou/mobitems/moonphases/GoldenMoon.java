package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.plugin.Plugin;

public class GoldenMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public GoldenMoon(Plugin plugin, int stage, boolean stopping) {
        super(plugin, stage, stopping);
    }

    public GoldenMoon(Plugin plugin, int stage){
        super(plugin, stage);
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
