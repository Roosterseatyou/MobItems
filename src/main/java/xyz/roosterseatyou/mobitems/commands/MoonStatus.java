package xyz.roosterseatyou.mobitems.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.moonphases.BloodMoon;
import xyz.roosterseatyou.mobitems.moonphases.BlueMoon;
import xyz.roosterseatyou.mobitems.moonphases.GoldenMoon;
import xyz.roosterseatyou.mobitems.moonphases.WaterMoon;

public class MoonStatus implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage(Component.text(
                "Moon Status ========\n" +
                        "Blood Moon: Status: " + BloodMoon.isServerActive() + ", Current Chance: " + BloodMoon.getServerChance() + "\n" +
                        "Blue Moon: Status: " + BlueMoon.isServerActive() + ", Current Chance: " + (double) BlueMoon.getServerChance()/2 + "\n" +
                        "Golden Moon: Status: " + GoldenMoon.isServerActive() + ", Current Chance: " + GoldenMoon.getServerChance() + "\n" +
                        "Water Moon: Status: " + WaterMoon.isServerActive() + ", Current Chance: " + WaterMoon.getServerChance() + "\n"));
        return false;
    }
}
