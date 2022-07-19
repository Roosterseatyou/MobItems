package xyz.roosterseatyou.mobitems.events;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.roosterseatyou.mobitems.MobItems;

import java.io.File;

public class JoinListeners implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(createNewPlayerFile(e.getPlayer()));
    }

    public static File createNewPlayerFile(Player p) {
        File f = new File("plugins/" + MobItems.getInstance().getDataFolder().getName() + "/players/" + p.getUniqueId() + ".yml");
        if (!f.exists()) {
            MobItems.log.info("Creating new player file for " + p.getName());
            try {
                f.createNewFile();
                MobItems.log.info("Created new player file for " + p.getName());
            } catch (Exception e) {
                MobItems.log.info("Failed to create new player file for " + p.getName());
            }
        }
        return f;
    }
}
