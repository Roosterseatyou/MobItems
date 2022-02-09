package xyz.roosterseatyou.mobitems;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.commands.*;
import xyz.roosterseatyou.mobitems.events.*;
import xyz.roosterseatyou.mobitems.events.aquatic.*;
import xyz.roosterseatyou.mobitems.events.aquatic.glowsquid.GlowSquidListeners;
import xyz.roosterseatyou.mobitems.events.aquatic.turtle.TurtleListeners;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.chicken.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.cow.*;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.*;
import xyz.roosterseatyou.mobitems.events.hybridevents.drowned.*;
import xyz.roosterseatyou.mobitems.events.moonphases.*;
import xyz.roosterseatyou.mobitems.events.nether.strider.StriderListeners;
import xyz.roosterseatyou.mobitems.events.undeadevents.*;
import xyz.roosterseatyou.mobitems.events.undeadevents.zombie.*;
import xyz.roosterseatyou.mobitems.events.undetermined.rabbit.*;
import xyz.roosterseatyou.mobitems.events.undetermined.snowgolem.*;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidTentacles;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish.PufferfishLips;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleChest;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleFeet;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleHead;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.*;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.*;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.*;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFace;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.*;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.*;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxPaws;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.*;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.*;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerNose;

import java.util.logging.Logger;

public final class MobItems extends JavaPlugin {
    private static Plugin instance;
    public static Logger log;

    @Override
    public void onEnable() {
        instance = this;
        log = getLogger();
        items();
        saveDefaultConfig();
        saveResource("death-counts.yml", false);
        getServer().getPluginManager().registerEvents(new GoldenMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new BloodMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new WaterMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new BlueMoonListeners(), this);
        getServer().getPluginManager().registerEvents(new RabbitListeners(), this);
        getServer().getPluginManager().registerEvents(new CowListeners(), this);
        getServer().getPluginManager().registerEvents(new SheepListeners(), this);
        getServer().getPluginManager().registerEvents(new FarmAnimalEvents(), this);
        getServer().getPluginManager().registerEvents(new ChickenListeners(), this);
        getServer().getPluginManager().registerEvents(new UndeadEvents(), this);
        getServer().getPluginManager().registerEvents(new ZombieEvents(), this);
        getServer().getPluginManager().registerEvents(new AquaticEvents(), this);
        getServer().getPluginManager().registerEvents(new DrownedEvents(this), this);
        getServer().getPluginManager().registerEvents(new AllTheTimeListeners(), this);
        getServer().getPluginManager().registerEvents(new SnowGolemListeners(), this);
        getServer().getPluginManager().registerEvents(new GlowSquidListeners(), this);
        getServer().getPluginManager().registerEvents(new StriderListeners(), this);
        getServer().getPluginManager().registerEvents(new TurtleListeners(), this);
        getServer().getPluginManager().registerEvents(new DeathCountListener(), this);
        this.getCommand("moonstatus").setExecutor(new MoonStatus());
        this.getCommand("setmoon").setExecutor(new SetMoon());
        this.getCommand("testmode").setExecutor(new TestMode());
        this.getCommand("simfishrng").setExecutor(new SimFishRNG());
        AquaticEvents.aquatic();
        new DrownedEvents(this);
        DrownedEvents.waterPowers();
        UndeadEvents.playerBurn(this);
        MoonStarter.moonStarter();
        SnowGolemListeners.snowGolemBurn(this);
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
        SnowGolemMask.init();
        SnowGolemChest.init();
        SnowGolemLegs.init();
        SnowGolemFeet.init();
        FoxMask.init();
        FoxLegs.init();
        FoxChest.init();
        FoxPaws.init();
        GlowSquidMask.init();
        GlowSquidTentacles.init();
        StriderFeet.init();
        StriderFace.striderFace();
        TurtleHead.init();
        TurtleChest.init();
        TurtleLegs.init();
        TurtleFeet.init();
        VillagerNose.init();
        VillagerChest.init();
        VillagerLegs.init();
        VillagerFeet.init();
        PufferfishLips.init();

    }

    public static Plugin getInstance(){
        return instance;
    }
}
