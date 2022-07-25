package xyz.roosterseatyou.mobitems.events.aquatic.salmon;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

public class SalmonListeners implements Listener {
    @EventHandler
    public void onPlayerDrown(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.DROWNING){
            if(e.getEntity() instanceof Player){
                Player p = (Player) e.getEntity();
                if(AquaticUtils.isSalmonArmor(p.getInventory().getHelmet())){
                    e.setCancelled(true);
                }
            }
        }
    }
}
