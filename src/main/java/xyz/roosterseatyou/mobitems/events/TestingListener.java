package xyz.roosterseatyou.mobitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieMask;

public class TestingListener implements Listener {
    @EventHandler
    public void onPlayerThing(PlayerJoinEvent e){
        e.getPlayer().getInventory().addItem(ZombieMask.ZOMBIE_MASK);
    }
}
