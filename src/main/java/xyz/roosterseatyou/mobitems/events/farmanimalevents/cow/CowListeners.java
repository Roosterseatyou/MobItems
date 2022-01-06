package xyz.roosterseatyou.mobitems.events.farmanimalevents.cow;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.roosterseatyou.mobitems.MobItems;

public class CowListeners implements Listener {
    private static MobItems plugin;

    public CowListeners(MobItems plugin){
        CowListeners.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeftClick(PlayerInteractEvent e){
        Bukkit.getScheduler().runTaskLater(plugin, () -> e.getPlayer().sendMessage("hi"), 2);
    }

}
