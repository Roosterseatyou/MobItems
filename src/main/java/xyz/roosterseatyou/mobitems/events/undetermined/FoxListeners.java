package xyz.roosterseatyou.mobitems.events.undetermined;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class FoxListeners implements Listener {
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent e){
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        if(PlayerInventoryUtils.isFoxArmor(newItem) && e.getSlotType().equals(PlayerArmorChangeEvent.SlotType.FEET)){
            e.getPlayer().setSilent(true);
        } else if(PlayerInventoryUtils.isFoxArmor(oldItem) && e.getSlotType().equals(PlayerArmorChangeEvent.SlotType.FEET)){
            e.getPlayer().setSilent(false);
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        Player p = e.getPlayer();
        ItemStack i = e.getItem();
        if(PlayerInventoryUtils.isFoxArmor(p.getInventory().getHelmet()) && i.getType().equals(Material.SWEET_BERRIES)){
            p.setFoodLevel(p.getFoodLevel()+4);
            p.setSaturation(p.getSaturation()+4);
        }
    }
}
