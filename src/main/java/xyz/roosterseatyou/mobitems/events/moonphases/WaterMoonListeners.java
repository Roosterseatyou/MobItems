package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerFishEvent;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.moonphases.WaterMoon;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class WaterMoonListeners implements Listener {
    @EventHandler
    public void onFish(PlayerFishEvent e){
        FileConfiguration config = MobItems.getInstance().getConfig();
        if(WaterMoon.isServerActive() && MathUtils.rngHelper(config.getInt("fish-special-chance"))){
            if(e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
                e.getPlayer().getInventory().addItem(ListContainers.getRandAquatic());
            }
        } else if(WaterMoon.isServerActive() && MathUtils.rngHelper(config.getInt("fish-drowned-chance"))){
            e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.DROWNED);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        FileConfiguration config = MobItems.getInstance().getConfig();
        if(WaterMoon.isServerActive() && e.getEntity() instanceof Drowned && config.getBoolean("drowned-extra-health")){
            Drowned ent = (Drowned) e.getEntity();
            ent.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(config.getInt("drowned-extra-health-value"));
            ent.setHealth(config.getInt("drowned-extra-health-value"));
        }
    }
}
