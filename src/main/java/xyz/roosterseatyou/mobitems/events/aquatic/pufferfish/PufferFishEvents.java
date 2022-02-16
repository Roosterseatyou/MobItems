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
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            int amt = AquaticUtils.getPufferArmorCount(p);
            if (e.getDamager() instanceof LivingEntity) {
                LivingEntity damager = (LivingEntity) e.getDamager();
                if (amt != 0) {
                    if (amt == 2) {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 1));
                    } else if (amt == 1) {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 0));
                    }
                }
            } else if(e.getDamager() instanceof Arrow){
                Arrow arrow = (Arrow) e.getDamager();
                if(arrow.getShooter() instanceof LivingEntity){
                    LivingEntity shooter = (LivingEntity) arrow.getShooter();
                    if (amt == 2) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 1));
                    } else if (amt == 1) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 0));
                    }
                }
            }
        }
    }
}
