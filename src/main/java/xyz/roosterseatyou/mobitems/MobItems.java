package xyz.roosterseatyou.mobitems;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.commands.TestMode;
import xyz.roosterseatyou.mobitems.commands.VillagerTestMode;
import xyz.roosterseatyou.mobitems.events.AllTheTimeListeners;
import xyz.roosterseatyou.mobitems.events.EntityDeathListeners;
import xyz.roosterseatyou.mobitems.events.JoinListeners;
import xyz.roosterseatyou.mobitems.events.aquatic.AquaticEvents;
import xyz.roosterseatyou.mobitems.events.aquatic.axolotl.AxolotlListeners;
import xyz.roosterseatyou.mobitems.events.aquatic.glowsquid.GlowSquidListeners;
import xyz.roosterseatyou.mobitems.events.aquatic.pufferfish.PufferFishEvents;
import xyz.roosterseatyou.mobitems.events.aquatic.turtle.TurtleListeners;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.FarmAnimalEvents;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.chicken.ChickenListeners;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.cow.CowListeners;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.SheepListeners;
import xyz.roosterseatyou.mobitems.events.hybridevents.drowned.DrownedEvents;
import xyz.roosterseatyou.mobitems.events.nether.strider.StriderListeners;
import xyz.roosterseatyou.mobitems.events.undeadevents.UndeadEvents;
import xyz.roosterseatyou.mobitems.events.undeadevents.zombie.ZombieEvents;
import xyz.roosterseatyou.mobitems.events.undetermined.rabbit.RabbitListeners;
import xyz.roosterseatyou.mobitems.events.undetermined.snowgolem.SnowGolemListeners;
import xyz.roosterseatyou.mobitems.events.undetermined.villager.VillagerListeners;
import xyz.roosterseatyou.mobitems.events.undetermined.villager.VillagerProfessionListeners;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.axolotl.AxolotlFins;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.axolotl.AxolotlLips;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidTentacles;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish.PufferfishChest;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish.PufferfishLips;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleChest;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleFeet;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleHead;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenBeak;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenFeet;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenThighs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenWings;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFace;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedMask;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxPaws;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.*;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemMask;
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
        getServer().getPluginManager().registerEvents(new VillagerListeners(), this);
        getServer().getPluginManager().registerEvents(new VillagerProfessionListeners(), this);
        getServer().getPluginManager().registerEvents(new PufferFishEvents(), this);
        getServer().getPluginManager().registerEvents(new AxolotlListeners(), this);
        getServer().getPluginManager().registerEvents(new JoinListeners(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListeners(), this);
        this.getCommand("testmode").setExecutor(new TestMode());
        this.getCommand("villagertestmode").setExecutor(new VillagerTestMode());
        AquaticEvents.aquatic();
        new DrownedEvents(this);
        DrownedEvents.waterPowers();
        UndeadEvents.playerBurn(this);
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
        PufferfishChest.init();
        AxolotlFins.init();
        AxolotlLips.init();
    }

    public static Plugin getInstance(){
        return instance;
    }
}
