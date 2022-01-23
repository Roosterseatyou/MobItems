package xyz.roosterseatyou.mobitems.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class SimFishRNG implements CommandExecutor {
    private static int timeCounter = 0;
    private static int getCounter = 0;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        timeCounter++;
        if (commandSender instanceof Player) {
            Player sender = (Player) commandSender;
            if (MathUtils.rngHelper(5)) {
                sender.getInventory().addItem(ListContainers.getRandAquatic());
                getCounter++;
                sender.sendMessage(Component.text("You have gotten " + getCounter + " after " + timeCounter + " tries!"));
            }else if (MathUtils.rngHelper(10)) {
                sender.getWorld().spawnEntity(sender.getLocation(), EntityType.DROWNED);
            }
        }
        return false;
    }
}
