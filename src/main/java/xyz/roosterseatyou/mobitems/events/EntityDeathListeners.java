package xyz.roosterseatyou.mobitems.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import xyz.roosterseatyou.mobitems.MobItems;

import java.io.File;
import java.io.IOException;

public class EntityDeathListeners implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if(e.getEntity().getKiller() != null) {
            Player p = e.getEntity().getKiller();
            FileConfiguration playerFile = getPlayerFile(p);

            playerFile.set("mob-kills." + e.getEntityType().name().toLowerCase(), playerFile.getInt("mob-kills." + e.getEntityType().name()) + 1);
            //TODO: once i rethink the moon system, i will double the kill count for the moon phase
            try {
                playerFile.save(getFile(p));
            } catch (IOException ex) {
                MobItems.log.info("Failed to save player file for " + p.getName());
            }
        }
    }

    public static FileConfiguration getPlayerFile(Player p) {
        FileConfiguration playerFile = null;
        File f = new File("plugins/" + MobItems.getInstance().getDataFolder().getName() + "/players/" + p.getUniqueId() + ".yml");
        if (f.exists()) {
            playerFile = YamlConfiguration.loadConfiguration(f);
        }
        return playerFile;
    }

    public static File getFile(Player p) {
        return new File("plugins/" + MobItems.getInstance().getDataFolder().getName() + "/players/" + p.getUniqueId() + ".yml");
    }
}
