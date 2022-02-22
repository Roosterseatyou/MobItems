package xyz.roosterseatyou.mobitems.events.moonphases;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.*;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

public class MoonStarter {
    public static void moonStarter() {
        FileConfiguration config = MobItems.getInstance().getConfig();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(MobItems.getInstance(), () -> {
            boolean isSpecial = MoonPhase.isActiveMoonPhase();
            int bloodMoonChance = BloodMoon.getServerChance();
            int blueMoonChance = BlueMoon.getServerChance();
            int goldenMoonChance = GoldenMoon.getServerChance();
            int waterMoonChance = WaterMoon.getServerChance();
            long time = Bukkit.getWorld(config.getString("world-names")).getTime();
            if(12000 < time && time < 12100){
                if(MathUtils.rngHelper(bloodMoonChance) && !isSpecial){
                    BloodMoon.setServerActive(true);
                    BloodMoon.setServerChance(0);
                    MoonPhase.setActiveMoonPhase(true);
                    Bukkit.broadcast(Component.text("You feel a gust of cool air hit your face as a Blood Moon rises.").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#470a0a")));
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new BloodMoon(false), MoonPhaseChangeEvent.Activator.TIME));
                } else if(MathUtils.complexRngHelper(blueMoonChance, 200) && !isSpecial){
                    BlueMoon.setServerActive(true);
                    BlueMoon.setServerChance(0);
                    MoonPhase.setActiveMoonPhase(true);
                    Bukkit.broadcast(Component.text("You feel a sense of overwhelming confidence as a BlueMoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#1761bd")));
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new BlueMoon(false), MoonPhaseChangeEvent.Activator.TIME));
                } else if(MathUtils.rngHelper(goldenMoonChance) && !isSpecial){
                    GoldenMoon.setServerActive(true);
                    GoldenMoon.setServerChance(0);
                    MoonPhase.setActiveMoonPhase(true);
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new GoldenMoon(false), MoonPhaseChangeEvent.Activator.TIME));
                    Bukkit.broadcast(Component.text("You see the moon shine brighter than it ever has as a Goldmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#dea821")));
                } else if(MathUtils.rngHelper(waterMoonChance) && !isSpecial){
                    WaterMoon.setServerActive(true);
                    WaterMoon.setServerChance(0);
                    MoonPhase.setActiveMoonPhase(true);
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new WaterMoon(false), MoonPhaseChangeEvent.Activator.TIME));
                    Bukkit.broadcast(Component.text("You feel a sprinkle of salt water hit your face as a Watermoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#315fb5")));
                } else if(!isSpecial){
                    BloodMoon.setServerChance(bloodMoonChance + 1);
                    BlueMoon.setServerChance(blueMoonChance + 1);
                    GoldenMoon.setServerChance(goldenMoonChance + 1);
                    WaterMoon.setServerChance(waterMoonChance + 1);
                }
            } else if (23000 < time && time < 23100) {
                if (isSpecial){
                    MoonPhase.setActiveMoonPhase(false);
                    Bukkit.broadcast(Component.text("The moon has set. You may go back to your pathetic lives.."));
                    Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new MoonPhase(true), MoonPhaseChangeEvent.Activator.TIME));
                }
                BloodMoon.setServerActive(false);
                BlueMoon.setServerActive(false);
                GoldenMoon.setServerActive(false);
                WaterMoon.setServerActive(false);
            }
        }, 0L, 99L);
    }
}
