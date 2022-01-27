package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerFishEvent;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.WaterMoon;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class WaterMoonListeners implements Listener {
    private static int stage;

    @EventHandler
    public void onFish(PlayerFishEvent e){
        if(WaterMoon.isServerActive() && MathUtils.rngHelper(stage)){
            if(e.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
                e.getPlayer().getInventory().addItem(ListContainers.getRandAquatic());
            }
        } else if(WaterMoon.isServerActive() && MathUtils.rngHelper(10)){
            e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.DROWNED);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(WaterMoon.isServerActive() && e.getEntity() instanceof Drowned){
            Drowned ent = (Drowned) e.getEntity();
            ent.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50);
            ent.setHealth(50);
            ent.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(7);
            ent.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(15);
        }
    }
}
