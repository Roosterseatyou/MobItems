package xyz.roosterseatyou.mobitems.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.roosterseatyou.mobitems.MobItems;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

public class DeathCountListener implements Listener {
    private static final HashMap<UUID, Long> cooldown = new HashMap<>();
    FileConfiguration deathData = YamlConfiguration.loadConfiguration(new File(MobItems.getInstance().getDataFolder()+"/"+ "death-counts.yml"));
    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException {
        if(!deathData.contains(String.valueOf(e.getPlayer().getUniqueId()))){
            MobItems.log.log(Level.INFO, "Adding new player into death-counts");
            deathData.createSection(String.valueOf(e.getPlayer().getUniqueId()));
            deathData.set(String.valueOf(e.getPlayer().getUniqueId()), 0);
            deathData.save(new File(MobItems.getInstance().getDataFolder()+"/"+ "death-counts.yml"));
            MobItems.log.log(Level.INFO, "Added new player successfully.");
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) throws IOException {
        int cooldownTime = MobItems.getInstance().getConfig().getInt("death-count-cooldown");
        Player p = e.getPlayer();
        FileConfiguration config = MobItems.getInstance().getConfig();
        if(config.getBoolean("death-count-affects-undead-chance")){
            if (cooldown.containsKey(p.getUniqueId())) {
                long timeLeft = ((cooldown.get(p.getUniqueId())/1000) + cooldownTime) - System.currentTimeMillis() / 1000;
                if(timeLeft > 0) {
                    p.sendActionBar(Component.text("You still have to wait " + timeLeft + " seconds to get death credit again!").color(TextColor.color(4, 85, 110)));
                }
            } else {
                deathData.set(String.valueOf(p.getUniqueId()), deathData.getInt(String.valueOf(e.getPlayer().getUniqueId())) + 1);
                deathData.save(new File(MobItems.getInstance().getDataFolder() + "/" + "death-counts.yml"));
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());
            }
        }
    }
}
