package xyz.roosterseatyou.mobitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.events.TestingListener;
import xyz.roosterseatyou.mobitems.itemstacks.zombie.ZombieMask;

public final class MobItems extends JavaPlugin {

    @Override
    public void onEnable() {
        items();
        getServer().getPluginManager().registerEvents(new TestingListener(), this);
        Bukkit.getConsoleSender().sendMessage("Good Job!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void items(){
        ZombieMask.init();
    }
}
