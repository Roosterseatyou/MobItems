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
                    if (amt >= 3) {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3, 1));
                    } else {
                        damager.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3, 0));
                    }
                }
            } else if(e.getDamager() instanceof Arrow){
                Arrow arrow = (Arrow) e.getDamager();
                if(arrow.getShooter() instanceof LivingEntity){
                    LivingEntity shooter = (LivingEntity) arrow.getShooter();
                    if (amt >= 3) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3, 1));
                    } else {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 3, 0));
                    }
                }
            }
        }
    }
}
