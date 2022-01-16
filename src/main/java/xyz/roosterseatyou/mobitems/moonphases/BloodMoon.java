package xyz.roosterseatyou.mobitems.moonphases;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;

public class BloodMoon extends MoonPhase{
    private static int chance = 1;
    private static boolean active = false;

    public BloodMoon(Plugin plugin, int stage, boolean stopping) {
        super(plugin, stage, stopping);
        if(stopping){
            setServerActive(false);
        }
    }

    public BloodMoon(Plugin plugin, int stage){
        super(plugin, stage);
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
