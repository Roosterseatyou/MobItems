package xyz.roosterseatyou.mobitems.events.farmanimalevents.chicken;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.FarmAnimalArmorUtils;

public class ChickenListeners implements Listener {
    @EventHandler
    public void slowFall(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        if(FarmAnimalArmorUtils.isChickenArmor(newItem)){
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, 0));
        } else if(FarmAnimalArmorUtils.isChickenArmor(oldItem)){
            p.removePotionEffect(PotionEffectType.SLOW_FALLING);
        }
    }

    @EventHandler
    public void eggFire(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if(FarmAnimalArmorUtils.hasChickenSet(p) && !p.isSneaking()){
            p.launchProjectile(Egg.class, p.getLocation().getDirection().multiply(5.0D));
        }
    }
}
