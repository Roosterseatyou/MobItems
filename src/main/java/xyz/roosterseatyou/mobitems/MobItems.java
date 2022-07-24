package xyz.roosterseatyou.mobitems;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.roosterseatyou.mobitems.api.events.EventHandler;
import xyz.roosterseatyou.mobitems.events.EntityDeathListeners;
import xyz.roosterseatyou.mobitems.events.JoinListeners;
import xyz.roosterseatyou.mobitems.moons.BloodMoon;
import xyz.roosterseatyou.mobitems.moons.SuperBloodMoon;

import java.util.logging.Logger;

public final class MobItems extends JavaPlugin {
    private static Plugin instance;
    public static Logger log;

    @Override
    public void onEnable() {
        instance = this;
        log = getLogger();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListeners(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListeners(), this);
        EventHandler.dayNightCycleChange(this);
        BloodMoon.BLOOD_MOON.register();
        SuperBloodMoon.SUPER_BLOOD_MOON.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance(){
        return instance;
    }
}
