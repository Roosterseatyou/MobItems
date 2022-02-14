package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemEnterInventoryEventHandler implements Listener {
    @EventHandler
    public void onPickup(EntityPickupItemEvent e){
        Bukkit.getServer().getPluginManager().callEvent(new ItemEnterInventoryEvent(e.g));
    }
}
