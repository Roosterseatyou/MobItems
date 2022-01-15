package xyz.roosterseatyou.mobitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitMask;

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
        e.getPlayer().getInventory().addItem(CowMask.COW_MASK);
        e.getPlayer().getInventory().addItem(CowChest.COW_CHEST);
        e.getPlayer().getInventory().addItem(CowLegs.COW_LEGS);
        e.getPlayer().getInventory().addItem(CowHooves.COW_HOOVES);
        e.getPlayer().getInventory().addItem(RabbitMask.RABBIT_MASK);
        e.getPlayer().getInventory().addItem(RabbitChest.RABBIT_CHEST);
        e.getPlayer().getInventory().addItem(RabbitLegs.RABBIT_LEGS);
        e.getPlayer().getInventory().addItem(RabbitFeet.RABBIT_FEET);
    }
}
