package xyz.roosterseatyou.mobitems.events.aquatic.pufferfish;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PufferFishEvents implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player p) {
            if (e.getDamager() instanceof Player damager) {
                damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
            } else if(e.getDamager() instanceof Arrow arrow){
                if(arrow.getShooter() instanceof Player shooter){
                    shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
                }
            }
        }
    }
}
