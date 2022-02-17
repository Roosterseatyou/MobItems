package xyz.roosterseatyou.mobitems.events.aquatic.axolotl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

import java.util.HashMap;
import java.util.UUID;

public class AxolotlListeners implements Listener {
    private static final HashMap<UUID, Boolean> isDead = new HashMap<>();

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (!p.isSneaking() && AquaticUtils.hasAxolotlSet(p)) {
            isDead.put(p.getUniqueId(), false);
        }
    }

    //cringe, ik
    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (isDead.containsKey(p.getUniqueId())) {
            if (isDead.get(p.getUniqueId()) && AquaticUtils.hasAxolotlSet(p)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent e){
        if(e.getTarget() instanceof Player) {
            Player p = (Player) e.getTarget();
            if (isDead.containsKey(p.getUniqueId())) {
                if (isDead.get(p.getUniqueId()) && AquaticUtils.hasAxolotlSet(p)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
