package xyz.roosterseatyou.mobitems.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.BloodMoon;
import xyz.roosterseatyou.mobitems.moonphases.BlueMoon;
import xyz.roosterseatyou.mobitems.moonphases.GoldenMoon;
import xyz.roosterseatyou.mobitems.moonphases.WaterMoon;

public class SetMoon implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        String type = args[0];
        int stage = 1;
        boolean starting = true;
        starting = Boolean.parseBoolean(args[1]);
        if(type.equals("blood_moon")){
            BloodMoon.setServerActive(starting);
            Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new BloodMoon(!starting), MoonPhaseChangeEvent.Activator.COMMAND));
        } else if(type.equals("blue_moon")){
            BlueMoon.setServerActive(starting);
            Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new BlueMoon(!starting), MoonPhaseChangeEvent.Activator.COMMAND));
        } else if (type.equals("golden_moon")) {
            GoldenMoon.setServerActive(starting);
            Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new GoldenMoon(!starting), MoonPhaseChangeEvent.Activator.COMMAND));
        } else if (type.equals("water_moon")){
            WaterMoon.setServerActive(starting);
            Bukkit.getPluginManager().callEvent(new MoonPhaseChangeEvent(new WaterMoon(!starting), MoonPhaseChangeEvent.Activator.COMMAND));
        } else {
            commandSender.sendMessage("Not a valid moon type!");
        }
        return true;
    }
}
