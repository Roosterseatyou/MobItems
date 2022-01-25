package xyz.roosterseatyou.mobitems.events.undetermined.snowgolem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UndeadArmorUtils;

public class SnowGolemListeners implements Listener {


    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player damaged = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();
            if(PlayerInventoryUtils.hasSnowSet(damager) && !damaged.isFrozen()){
                damaged.setFreezeTicks(200);
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getType().equals(Material.AIR) && PlayerInventoryUtils.isSnowGolemArmor(p.getInventory().getChestplate()) && e.getAction() == Action.RIGHT_CLICK_AIR){
            p.launchProjectile(Snowball.class);
        }
    }
    public static void snowGolemBurn(Plugin plugin){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()){
                if (PlayerInventoryUtils.hasSnowSet(p) && UndeadArmorUtils.inSunlight(p)){
                    p.setFireTicks(200);
                }
            }

        }, 0L, 100L);
    }

}
