package xyz.roosterseatyou.mobitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.events.TestingListener;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.FarmAnimalEvents;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.SheepListeners;
import xyz.roosterseatyou.mobitems.events.undeadevents.UndeadEvents;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieMask;

public final class MobItems extends JavaPlugin {

    @Override
    public void onEnable() {

        items();
        new UndeadEvents(this);
        UndeadEvents.playerBurn();
        getServer().getPluginManager().registerEvents(new SheepListeners(), this);
        getServer().getPluginManager().registerEvents(new FarmAnimalEvents(), this);
        getServer().getPluginManager().registerEvents(new TestingListener(), this);
        Bukkit.getConsoleSender().sendMessage("Good Job!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void items(){
        ZombieMask.init();
        ZombieChest.init();
        ZombieLegs.init();
        ZombieFeet.init();
        SheepMask.init();
        SheepChest.init();
        SheepLegs.init();
        SheepHooves.init();
    }
}
