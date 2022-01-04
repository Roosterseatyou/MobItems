package xyz.roosterseatyou.mobitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieMask;

public class TestingListener implements Listener {
    @EventHandler
    public void onPlayerThing(PlayerJoinEvent e){
        e.getPlayer().getInventory().addItem(ZombieMask.ZOMBIE_MASK);
        e.getPlayer().getInventory().addItem(ZombieChest.ZOMBIE_CHEST);
        e.getPlayer().getInventory().addItem(ZombieLegs.ZOMBIE_LEGS);
        e.getPlayer().getInventory().addItem(ZombieFeet.ZOMBIE_FEET);
        e.getPlayer().getInventory().addItem(SheepMask.SHEEP_MASK);
        e.getPlayer().getInventory().addItem(SheepChest.SHEEP_CHEST);
        e.getPlayer().getInventory().addItem(SheepLegs.SHEEP_LEGS);
        e.getPlayer().getInventory().addItem(SheepHooves.SHEEP_HOOVES);
    }
}
