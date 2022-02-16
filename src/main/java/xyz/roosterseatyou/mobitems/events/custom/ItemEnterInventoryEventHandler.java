package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemEnterInventoryEventHandler implements Listener {
    @EventHandler
    public void onPickup(EntityPickupItemEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            Bukkit.getServer().getPluginManager().callEvent(new PlayerObtainItemEvent(p, e.getItem().getItemStack(), PlayerObtainItemEvent.Reason.PICK_UP));
        }
    }

    @EventHandler
    public void moveItem(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && e.getClickedInventory() == p.getInventory()){
            Bukkit.getServer().getPluginManager().callEvent(new PlayerObtainItemEvent(p, e.getCurrentItem(), PlayerObtainItemEvent.Reason.PICK_UP));
        }
    }
}
