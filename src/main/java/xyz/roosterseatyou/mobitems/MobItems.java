package xyz.roosterseatyou.mobitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Good Job!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
