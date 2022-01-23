package xyz.roosterseatyou.mobitems.events.underwaterevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UnderWaterArmorUtils;

public class UnderWaterEvents implements Listener{
    public static void aquatic(Plugin plugin){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()){
                if (UnderWaterArmorUtils.hasFullSet(p)){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER , 125, 2));
                }
            }
        }, 0L, 100L);
    }
}
