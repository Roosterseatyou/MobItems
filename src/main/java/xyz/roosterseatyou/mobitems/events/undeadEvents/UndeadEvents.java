package xyz.roosterseatyou.mobitems.events.undeadEvents;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UndeadArmorUtils;


public class UndeadEvents{

    public static void playerBurn(){

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(new MobItems(), new Runnable() {
            @Override
            public void run(){
                for (Player p : Bukkit.getOnlinePlayers()){
                    if (UndeadArmorUtils.hasFullSet(p) && UndeadArmorUtils.inSunlight(p)){
                        p.setFireTicks(200);
                    }
                }

            }
        }, 0L, 100L);
    }

}
