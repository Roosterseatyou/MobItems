package xyz.roosterseatyou.mobitems.events.aquatic.turtle;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

    @EventHandler
    public void armorChange(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        int amp = AquaticUtils.getTurtArmorCount(p);
        if(AquaticUtils.isTurtArmor(e.getNewItem())){
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, amp-1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, amp-1));
        } else if(AquaticUtils.isTurtArmor(e.getOldItem())){
            p.removePotionEffect(PotionEffectType.SLOW);
            p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            if(amp == 0){
                return;
            }
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, amp-1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, amp-1));
        }
    }

}
