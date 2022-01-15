package xyz.roosterseatyou.mobitems.events.farmanimalevents.cow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.FarmAnimalArmorUtils;

public class CowListeners implements Listener {
    private static MobItems plugin;

    public CowListeners(MobItems plugin){
        CowListeners.plugin = plugin;
    }

    @EventHandler
    public void onEntityPotion(EntityPotionEffectEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(FarmAnimalArmorUtils.isCowSet(p)){
                e.setCancelled(true);
            }
        }
    }

    
}
