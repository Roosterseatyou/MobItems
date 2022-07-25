package xyz.roosterseatyou.mobitems.events.farmanimalevents;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep.SheepListeners;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.FarmAnimalArmorUtils;

public class FarmAnimalEvents implements Listener {
    @EventHandler
    public static void onPlayerLeftClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.GRASS_BLOCK
                && FarmAnimalArmorUtils.hasFullSet(p)){
            e.getClickedBlock().setType(Material.DIRT);
            p.setFoodLevel(p.getFoodLevel() + 6);
            if(FarmAnimalArmorUtils.isSheepSet(p)){
                SheepListeners.woolState.put(p, true);
            }
        }
    }
}
