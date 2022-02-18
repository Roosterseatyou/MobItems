package xyz.roosterseatyou.mobitems.events.aquatic.pufferfish;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

public class PufferFishEvents implements Listener {
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player p) {
            int amt = AquaticUtils.getPufferArmorCount(p);
            if (e.getDamager() instanceof LivingEntity damager) {
                if (amt != 0) {
                    if (amt == 2) {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
                    } else if (amt == 1) {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 0));
                    }
                }
            } else if(e.getDamager() instanceof Arrow arrow){
                if(arrow.getShooter() instanceof LivingEntity shooter){
                    if (amt == 2) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1));
                    } else if (amt == 1) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 0));
                    }
                }
            }
        }
    }
}
