package xyz.roosterseatyou.mobitems;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.commands.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.chicken.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.cow.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.*;
import xyz.roosterseatyou.mobitems.events.hybridevents.drowned.*;
import xyz.roosterseatyou.mobitems.events.moonphases.*;
import xyz.roosterseatyou.mobitems.events.undeadevents.*;
import xyz.roosterseatyou.mobitems.events.undeadevents.zombie.*;
import xyz.roosterseatyou.mobitems.events.underwaterevents.*;
import xyz.roosterseatyou.mobitems.events.undetermined.*;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.*;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.*;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.*;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.*;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.*;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.*;

public final class MobItems extends JavaPlugin {

    @Override
    public void onEnable() {
        items();
        getServer().getPluginManager().registerEvents(new GoldenMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new BloodMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new MoonAnnouncer(), this);
        getServer().getPluginManager().registerEvents(new RabbitListeners(), this);
        getServer().getPluginManager().registerEvents(new CowListeners(), this);
        getServer().getPluginManager().registerEvents(new SheepListeners(), this);
        getServer().getPluginManager().registerEvents(new FarmAnimalEvents(), this);
        getServer().getPluginManager().registerEvents(new ChickenListeners(), this);
        getServer().getPluginManager().registerEvents(new UndeadEvents(), this);
        getServer().getPluginManager().registerEvents(new ZombieEvents(), this);
        //getServer().getPluginManager().registerEvents(new UnderWaterEvents(this), this);
        getServer().getPluginManager().registerEvents(new DrownedEvents(this), this);
        this.getCommand("moonstatus").setExecutor(new MoonStatus());
        this.getCommand("setmoon").setExecutor(new SetMoon());
        this.getCommand("testmode").setExecutor(new TestMode());
        UnderWaterEvents.aquatic(this);
        new DrownedEvents(this);
        DrownedEvents.waterPowers();
        UndeadEvents.playerBurn(this);
        MoonStarter.moonStarter(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void items(){
        //Hostiles
        ZombieMask.init();
        ZombieChest.init();
        ZombieLegs.init();
        ZombieFeet.init();
        DrownedMask.init();
        DrownedChest.init();
        DrownedLegs.init();
        DrownedFeet.init();

        //Passives, Neutrals
        SheepMask.init();
        SheepChest.init();
        SheepLegs.init();
        SheepHooves.init();
        CowMask.init();
        CowChest.init();
        CowLegs.init();
        CowHooves.init();
        RabbitMask.init();
        RabbitChest.init();
        RabbitLegs.init();
        RabbitFeet.init();
        KillerRabbitMask.init();
        KillerRabbitChest.init();
        KillerRabbitLegs.init();
        KillerRabbitFeet.init();
        ChickenBeak.init();
        ChickenWings.init();
        ChickenThighs.init();
        ChickenFeet.init();
    }
}