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
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitLegs;

public class RabbitListeners implements Listener {


    @EventHandler
    public void jumpHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && (newItem.equals(RabbitFeet.RABBIT_FEET) || newItem.equals(KillerRabbitFeet.RABBIT_FEET))){
            p.addPotionEffect(jump);
        } else if(oldItem != null && (oldItem.equals(RabbitFeet.RABBIT_FEET) || oldItem.equals(KillerRabbitFeet.RABBIT_FEET))){
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }

    @EventHandler
    public void luckHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect luck = new PotionEffect(PotionEffectType.LUCK, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && (newItem.equals(RabbitFeet.RABBIT_FEET) || newItem.equals(KillerRabbitFeet.RABBIT_FEET))){
            p.addPotionEffect(luck);
        } else if(oldItem != null && (oldItem.equals(RabbitFeet.RABBIT_FEET) || oldItem.equals(KillerRabbitFeet.RABBIT_FEET))){
            p.removePotionEffect(PotionEffectType.LUCK);
        }
    }

    @EventHandler
    public void speedHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && (newItem.equals(RabbitLegs.RABBIT_LEGS) || newItem.equals(KillerRabbitLegs.RABBIT_LEGS))){
            p.addPotionEffect(speed);
        } else if(oldItem != null && (oldItem.equals(RabbitLegs.RABBIT_LEGS) || oldItem.equals(KillerRabbitLegs.RABBIT_LEGS))){
            p.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
