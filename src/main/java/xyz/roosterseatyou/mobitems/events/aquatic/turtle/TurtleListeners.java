package xyz.roosterseatyou.mobitems.events.aquatic.turtle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

public class TurtleListeners implements Listener {
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();
            if (AquaticUtils.hasTurtSet(p) && p.isInWaterOrBubbleColumn()){
                e.setDamage(e.getDamage()*3);
            }
        }
    }

}
