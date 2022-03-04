package xyz.roosterseatyou.mobitems.events.aquatic.glowsquid;

import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

public class GlowSquidListeners implements Listener {
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (AquaticUtils.hasGlowRing(p)) {
                if (e.getDamager() instanceof LivingEntity damager) {
                    damager.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 20, 1));
                } else if (e.getDamager() instanceof Arrow arrow) {
                    if (arrow.getShooter() instanceof LivingEntity shooter) {
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 20, 1));
                    }
                }
                p.getLocation().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, p.getLocation(), 20);
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player p && e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK){
            if(AquaticUtils.hasGlowRing(p)){
                p.getLocation().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, p.getLocation(), 20);
            }
        }
    }


}
