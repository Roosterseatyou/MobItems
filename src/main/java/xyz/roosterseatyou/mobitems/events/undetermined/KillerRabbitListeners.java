package xyz.roosterseatyou.mobitems.events.undetermined;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitLegs;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class KillerRabbitListeners implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        if(e.getNewItem() != null && !e.getNewItem().equals(Material.AIR) && PlayerInventoryUtils.hasKillerRabbitSet(p)){
            PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1);
            p.addPotionEffect(strength);
        } else if(e.getOldItem() != null && !e.getOldItem().equals(Material.AIR) && PlayerInventoryUtils.isKillerRabbitArmor(e.getOldItem())){
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
    }
    @EventHandler
    public void jumpHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && newItem.equals(KillerRabbitFeet.RABBIT_FEET)){
            p.addPotionEffect(jump);
        } else if(oldItem != null && oldItem.equals(KillerRabbitFeet.RABBIT_FEET)){
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }

    @EventHandler
    public void luckHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect luck = new PotionEffect(PotionEffectType.LUCK, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && newItem.equals(KillerRabbitFeet.RABBIT_FEET)){
            p.addPotionEffect(luck);
        } else if(oldItem != null && oldItem.equals(KillerRabbitFeet.RABBIT_FEET)){
            p.removePotionEffect(PotionEffectType.LUCK);
        }
    }

    @EventHandler
    public void speedHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && newItem.equals(KillerRabbitLegs.RABBIT_LEGS)){
            p.addPotionEffect(speed);
        } else if(oldItem != null && oldItem.equals(KillerRabbitLegs.RABBIT_LEGS)){
            p.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
