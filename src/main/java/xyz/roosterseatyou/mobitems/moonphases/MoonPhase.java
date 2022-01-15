package xyz.roosterseatyou.mobitems.moonphases;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

public class MoonPhase {
    //Stuff not related to the object...
    public static boolean isGoldenMoon = false;
    public static boolean isWaterMoon = false;
    public static boolean isSpecial = false;
    public static int goldenMoonChance = 1;
    public static int waterMoonChance = 1;
    private static Plugin plugin;


    public MoonPhase(Plugin plugin){
        MoonPhase.plugin = plugin;
    }

    public static void moonStarter() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            isSpecial = BloodMoon.isActive() || BlueMoon.isActive() || isGoldenMoon || isWaterMoon;
            if(12000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 12100){
                if(MathUtils.rngHelper(BloodMoon.getChance()) && !isSpecial){
                    BloodMoon.setActive(true);
                    BloodMoon.setChance(0);
                    Bukkit.broadcast(Component.text("You feel a gust of cold wind as a Bloodmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#330401")));
                } else if(MathUtils.rngHelper(BlueMoon.getChance()) && !isSpecial){
                    BlueMoon.setActive(true);
                    BlueMoon.setChance(0);
                    Bukkit.broadcast(Component.text("You sense a feeling of dread as a Bluemoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#040aba")));
                } else if(MathUtils.rngHelper(goldenMoonChance) && !BloodMoon.isActive() && !isSpecial){
                    isGoldenMoon = true;
                    goldenMoonChance = 0;
                    Bukkit.broadcast(Component.text("You see the moon shine brighter than it ever has as a Goldmoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#dea821")));
                } else if(MathUtils.rngHelper(waterMoonChance) && !isSpecial){
                    isWaterMoon = true;
                    waterMoonChance = 0;
                    Bukkit.broadcast(Component.text("You feel a sprinkle of salt water hit your face as a Watermoon rises").decorate(TextDecoration.ITALIC).color(TextColor.fromHexString("#315fb5")));
                } else if(!isSpecial){
                    BloodMoon.setChance(BloodMoon.getChance()+1);
                    BlueMoon.setChance(BlueMoon.getChance()+1);
                    goldenMoonChance++;
                    waterMoonChance++;
                }
            } else if (Bukkit.getWorld("world") != null && 23000 < Bukkit.getWorld("world").getTime() && Bukkit.getWorld("world").getTime() < 23100) {
                if (isSpecial){
                    Bukkit.broadcast(Component.text("The moon has set. You may go back to your pathetic lives.."));
                }
                isWaterMoon = false;
                isGoldenMoon = false;
                BlueMoon.setActive(false);
                BloodMoon.setActive(false);
            }
        }, 0L, 100L);
    }
}
