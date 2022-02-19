package xyz.roosterseatyou.mobitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerNose;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.VillagerUtils;

public class VillagerTestMode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            ItemStack nose = VillagerNose.VILLAGER_NOSE;
            ItemStack chest = VillagerChest.VILLAGER_CHEST;
            ItemStack legs = VillagerLegs.VILLAGER_LEGS;
            ItemStack feet = VillagerFeet.VILLAGER_FEET;
            VillagerUtils.addProfessionFromStr(nose, strings[0]);
            VillagerUtils.addProfessionFromStr(chest, strings[0]);
            VillagerUtils.addProfessionFromStr(legs, strings[0]);
            VillagerUtils.addProfessionFromStr(feet, strings[0]);
            player.getInventory().addItem(nose);
            player.getInventory().addItem(chest);
            player.getInventory().addItem(legs);
            player.getInventory().addItem(feet);
        }
        return false;
    }
}
