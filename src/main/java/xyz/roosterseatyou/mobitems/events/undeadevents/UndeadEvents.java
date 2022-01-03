package xyz.roosterseatyou.mobitems.events.undeadevents;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.event.Listener;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UndeadArmorUtils;


public class UndeadEvents implements Listener{

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
    @EventHandler
    public static void onDeath(EntityDamageEvent e){
        Entity ent= e.getEntity();
        if (ent instanceof Player){
            Player p = (Player)ent;

            if (e.getDamage() > p.getHealth() && UndeadArmorUtils.hasFullSet(p)){
                p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION , 125, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE , 125, 1));
            }
        }

    }

}
