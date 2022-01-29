package xyz.roosterseatyou.mobitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidTentacles;
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
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedMask;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitMask;

public class TestMode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            final Player commandSender1 = (Player) commandSender;
            commandSender1.getInventory().addItem(ZombieMask.ZOMBIE_MASK);
            commandSender1.getInventory().addItem(ZombieChest.ZOMBIE_CHEST);
            commandSender1.getInventory().addItem(ZombieLegs.ZOMBIE_LEGS);
            commandSender1.getInventory().addItem(ZombieFeet.ZOMBIE_FEET);
            commandSender1.getInventory().addItem(SheepMask.SHEEP_MASK);
            commandSender1.getInventory().addItem(SheepChest.SHEEP_CHEST);
            commandSender1.getInventory().addItem(SheepLegs.SHEEP_LEGS);
            commandSender1.getInventory().addItem(SheepHooves.SHEEP_HOOVES);
            commandSender1.getInventory().addItem(CowMask.COW_MASK);
            commandSender1.getInventory().addItem(CowChest.COW_CHEST);
            commandSender1.getInventory().addItem(CowLegs.COW_LEGS);
            commandSender1.getInventory().addItem(CowHooves.COW_HOOVES);
            commandSender1.getInventory().addItem(RabbitMask.RABBIT_MASK);
            commandSender1.getInventory().addItem(RabbitChest.RABBIT_CHEST);
            commandSender1.getInventory().addItem(RabbitLegs.RABBIT_LEGS);
            commandSender1.getInventory().addItem(RabbitFeet.RABBIT_FEET);
            commandSender1.getInventory().addItem(ChickenBeak.CHICKEN_BEAK);
            commandSender1.getInventory().addItem(ChickenWings.CHICKEN_WINGS);
            commandSender1.getInventory().addItem(ChickenThighs.CHICKEN_THIGHS);
            commandSender1.getInventory().addItem(ChickenFeet.CHICKEN_FEET);
            commandSender1.getInventory().addItem(DrownedMask.DROWNED_MASK);
            commandSender1.getInventory().addItem(DrownedChest.DROWNED_CHEST);
            commandSender1.getInventory().addItem(DrownedLegs.DROWNED_LEGS);
            commandSender1.getInventory().addItem(DrownedFeet.DROWNED_FEET);
            commandSender1.getInventory().addItem(GlowSquidMask.GLOW_LIPS);
            commandSender1.getInventory().addItem(GlowSquidTentacles.GLOW_TENTACLES);
        }
        return false;
    }
}
