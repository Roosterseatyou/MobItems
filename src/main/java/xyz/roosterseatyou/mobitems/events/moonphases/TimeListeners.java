package xyz.roosterseatyou.mobitems.events.moonphases;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

public class TimeListeners implements Listener {
    public static boolean isBloodMoon = false;
    public static boolean isBlueMoon = false;
    public static boolean isGoldenMoon = false;
    public static boolean isWaterMoon = false;
    public static boolean isSpecial = false;

    public static int bloodMoonChance = 1;
    public static int blueMoonChance = 1;
    public static int goldenMoonChance = 1;
    public static int waterMoonChance = 1;

    private static Plugin plugin;

    public TimeListeners(Plugin plugin){
        TimeListeners.plugin = plugin;
    }

    @EventHandler
    public static void moonStarter() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            isSpecial = isBloodMoon || isBlueMoon || isGoldenMoon || isWaterMoon;
            if(12000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 12100){
                if(MathUtils.rngHelper(bloodMoonChance) && !isBloodMoon && !isSpecial){
                    isBloodMoon = true;
                    bloodMoonChance = 0;
                    Bukkit.broadcast(Component.text("You feel a gust of cold wind as a Bloodmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#330401")));
                } else if(MathUtils.rngHelper(blueMoonChance) && !isSpecial){
                    isBlueMoon = true;
                    blueMoonChance = 0;
                    Bukkit.broadcast(Component.text("You sense a feeling of dread as a Bluemoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#040aba")));
                } else if(MathUtils.rngHelper(goldenMoonChance) && !isBloodMoon && !isSpecial){
                    isGoldenMoon = true;
                    goldenMoonChance = 0;
                    Bukkit.broadcast(Component.text("You see the moon shine brighter than it ever has as a Goldmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#dea821")));
                } else if(MathUtils.rngHelper(waterMoonChance) && !isBloodMoon && !isSpecial){
                    isWaterMoon = true;
                    waterMoonChance = 0;
                    Bukkit.broadcast(Component.text("You feel a sprinkle of salt water as a Watermoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#315fb5")));
                } else if(!isSpecial){
                    bloodMoonChance++;
                    blueMoonChance++;
                    goldenMoonChance++;
                    waterMoonChance++;
                }
            } else if (Bukkit.getWorld("world") != null && 23000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 23100) {
                if (isSpecial){
                    Bukkit.broadcast(Component.text("The moon has set. You may go back to your pathetic lives.."));
                }
                isWaterMoon = false;
                isGoldenMoon = false;
                isBlueMoon = false;
                isBloodMoon = false;
            }
        }, 0L, 100L);
    }
}
