package xyz.roosterseatyou.mobitems.events.moonphases;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.*;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

public class MoonStarter {
    private static Plugin plugin;

    public MoonStarter(Plugin plugin){
        MoonStarter.plugin = plugin;
    }

    public static void moonStarter() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            int stage = MathUtils.randomIntegerFromRange(1, 5);
            boolean isSpecial = MoonPhase.isActiveMoonPhase();
            int bloodMoonChance = BloodMoon.getServerChance();
            int blueMoonChance = BlueMoon.getServerChance();
            int goldenMoonChance = GoldenMoon.getServerChance();
            int waterMoonChance = WaterMoon.getServerChance();
            if(12000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 12100){
                if(MathUtils.rngHelper(bloodMoonChance) && !isSpecial){
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(Bukkit.getWorld("world"), new BloodMoon(plugin, stage)));
                    BloodMoon.setServerActive(true);
                    BloodMoon.setServerChance(0);
                } else if(MathUtils.rngHelper(blueMoonChance) && !isSpecial){
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(Bukkit.getWorld("world"), new BlueMoon(plugin, stage)));
                    BlueMoon.setServerActive(true);
                    BlueMoon.setServerChance(0);
                } else if(MathUtils.rngHelper(goldenMoonChance) && !isSpecial){
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(Bukkit.getWorld("world"), new GoldenMoon(plugin, stage)));
                    GoldenMoon.setServerActive(true);
                    GoldenMoon.setServerChance(0);
                    Bukkit.broadcast(Component.text("You see the moon shine brighter than it ever has as a Goldmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#dea821")));
                } else if(MathUtils.rngHelper(waterMoonChance) && !isSpecial){
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(Bukkit.getWorld("world"), new WaterMoon(plugin, stage)));
                    WaterMoon.setServerActive(true);
                    WaterMoon.setServerChance(0);
                    Bukkit.broadcast(Component.text("You feel a sprinkle of salt water hit your face as a Watermoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#315fb5")));
                } else if(!isSpecial){
                    BloodMoon.setServerChance(bloodMoonChance + 1);
                    BlueMoon.setServerChance(blueMoonChance + 1);
                    GoldenMoon.setServerChance(goldenMoonChance + 1);
                    WaterMoon.setServerChance(waterMoonChance + 1);
                }
            } else if (Bukkit.getWorld("world") != null && 23000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 23100) {
                if (isSpecial){
                    Bukkit.broadcast(Component.text("The moon has set. You may go back to your pathetic lives.."));
                }
                BloodMoon.setServerActive(false);
                BlueMoon.setServerActive(false);
                GoldenMoon.setServerActive(false);
                WaterMoon.setServerActive(false);
                Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(Bukkit.getWorld("world"), new GoldenMoon(plugin, stage, true)));
            }
        }, 0L, 99L);
    }
}