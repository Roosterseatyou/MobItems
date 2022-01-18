package xyz.roosterseatyou.mobitems.events.undetermined;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitMask;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class RabbitListeners implements Listener {


    @EventHandler
    public void jumpHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && e.getSlotType() == PlayerArmorChangeEvent.SlotType.FEET && (PlayerInventoryUtils.hasID(newItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(newItem, KillerRabbitMask.ENTITY_ID))){
            p.addPotionEffect(jump);
        } else if(oldItem != null && e.getSlotType() == PlayerArmorChangeEvent.SlotType.FEET && (PlayerInventoryUtils.hasID(oldItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(oldItem, KillerRabbitMask.ENTITY_ID))){
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }

    @EventHandler
    public void luckHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect luck = new PotionEffect(PotionEffectType.LUCK, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && e.getSlotType() == PlayerArmorChangeEvent.SlotType.FEET && (PlayerInventoryUtils.hasID(newItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(newItem, KillerRabbitMask.ENTITY_ID))){
            p.addPotionEffect(luck);
        } else if(oldItem != null && e.getSlotType() == PlayerArmorChangeEvent.SlotType.FEET && (PlayerInventoryUtils.hasID(oldItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(oldItem, KillerRabbitMask.ENTITY_ID))){
            p.removePotionEffect(PotionEffectType.LUCK);
        }
    }

    @EventHandler
    public void speedHandler(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1);
        if(newItem != null && !newItem.getType().equals(Material.AIR) && e.getSlotType() == PlayerArmorChangeEvent.SlotType.LEGS && (PlayerInventoryUtils.hasID(newItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(newItem, KillerRabbitMask.ENTITY_ID))){
            p.addPotionEffect(speed);
        } else if(oldItem != null && e.getSlotType() == PlayerArmorChangeEvent.SlotType.LEGS && (PlayerInventoryUtils.hasID(oldItem, RabbitMask.ENTITY_ID) || PlayerInventoryUtils.hasID(oldItem, KillerRabbitMask.ENTITY_ID))){
            p.removePotionEffect(PotionEffectType.SPEED);
        }
    }
}
