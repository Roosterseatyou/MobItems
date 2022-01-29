package xyz.roosterseatyou.mobitems.events.aquatic.glowsquid;

import com.destroystokyo.paper.ParticleBuilder;
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
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (AquaticUtils.hasGlowSet(p)) {
                if (e.getDamager() instanceof LivingEntity) {
                    LivingEntity damager = (LivingEntity) e.getDamager();
                    damager.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 20, 1));
                } else if (e.getDamager() instanceof Arrow) {
                    Arrow arrow = (Arrow) e.getDamager();
                    if (arrow.getShooter() instanceof LivingEntity) {
                        LivingEntity shooter = (LivingEntity) arrow.getShooter();
                        shooter.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 20, 1));
                    }
                }
                p.getLocation().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, p.getLocation(), 20);
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player && e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK){
            Player p = (Player) e.getEntity();
            if(AquaticUtils.hasGlowSet(p)){
                p.getLocation().getWorld().spawnParticle(Particle.GLOW_SQUID_INK, p.getLocation(), 20);
            }
        }
    }


}
