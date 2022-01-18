package xyz.roosterseatyou.mobitems.events.moonphases;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;

public class MoonAnnouncer implements Listener {
    @EventHandler
    public void onMoonChange(MoonPhaseChangeEvent e){
        Bukkit.broadcast(Component.text(e.toString()));
    }
}
