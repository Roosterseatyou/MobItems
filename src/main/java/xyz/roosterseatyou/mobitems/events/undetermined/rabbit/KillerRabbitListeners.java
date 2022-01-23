package xyz.roosterseatyou.mobitems.events.undetermined.rabbit;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class KillerRabbitListeners implements Listener {
    @EventHandler
    public void strengthHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        if(e.getNewItem() != null && !e.getNewItem().equals(Material.AIR) && PlayerInventoryUtils.hasKillerRabbitSet(p)){
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1);
            p.addPotionEffect(strength);
        } else if(e.getOldItem() != null && !e.getOldItem().equals(Material.AIR) && PlayerInventoryUtils.isKillerRabbitArmor(e.getOldItem())){
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
    }
}
