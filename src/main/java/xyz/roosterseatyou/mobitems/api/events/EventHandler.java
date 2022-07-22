package xyz.roosterseatyou.mobitems.api.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class EventHandler {

    public static void dayNightCycleChange(Plugin plugin) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            Bukkit.getWorlds().forEach(world -> {
                if (world.getTime() >=  13000 && world.getTime() <= 13020) {
                    //day is beginning
                    Bukkit.getPluginManager().callEvent(new DayNightCycleChangeEvent(world, true, false));
                } else {
                    Bukkit.getPluginManager().callEvent(new DayNightCycleChangeEvent(world, false, true));
                }
            });
        }, 0L, 20L);
    }
}
