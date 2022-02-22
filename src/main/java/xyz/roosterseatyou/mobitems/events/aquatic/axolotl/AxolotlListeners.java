package xyz.roosterseatyou.mobitems.events.aquatic.axolotl;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

import java.util.HashMap;
import java.util.UUID;

public class AxolotlListeners implements Listener {
    private static final HashMap<UUID, Boolean> isDead = new HashMap<>();

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (!p.isSneaking() && AquaticUtils.hasAxolotlCrown(p)) {
            if(isDead.containsKey(p.getUniqueId())) {
                if (!isDead.get(p.getUniqueId())) {
                    isDead.put(p.getUniqueId(), true);
                    Bukkit.getScheduler().runTaskLater(MobItems.getInstance(), () ->{ isDead.put(p.getUniqueId(), false); p.sendMessage(Component.text("You are no longer playing dead!").color(TextColor.color(255, 0, 0)));}, 30*20);
                    p.sendMessage(Component.text("You are now playing dead!").color(TextColor.color(57, 3, 252)));
                }
            } else {
                isDead.put(p.getUniqueId(), true);
                Bukkit.getScheduler().runTaskLater(MobItems.getInstance(), () ->{ isDead.put(p.getUniqueId(), false); p.sendMessage(Component.text("You are no longer playing dead!").color(TextColor.color(255, 0, 0)));}, 30*20);
                p.sendMessage(Component.text("You are now playing dead!").color(TextColor.color(57, 3, 252)));
            }
        }
    }

    //cringe, ik
    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (isDead.containsKey(p.getUniqueId())) {
            if (isDead.get(p.getUniqueId()) && AquaticUtils.hasAxolotlCrown(p)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent e){
        if(e.getTarget() instanceof Player p) {
            if (isDead.containsKey(p.getUniqueId())) {
                if (isDead.get(p.getUniqueId()) && AquaticUtils.hasAxolotlCrown(p)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
