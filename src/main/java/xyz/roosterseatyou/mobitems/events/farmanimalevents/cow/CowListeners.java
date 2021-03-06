package xyz.roosterseatyou.mobitems.events.farmanimalevents.cow;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.FarmAnimalArmorUtils;

public class CowListeners implements Listener {
    @EventHandler
    public void onEntityPotion(EntityPotionEffectEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(FarmAnimalArmorUtils.isCowSet(p) && e.getAction() == EntityPotionEffectEvent.Action.ADDED){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerMilk(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof LivingEntity){
            LivingEntity entity = (LivingEntity) e.getRightClicked();
            if(p.getInventory().getItemInMainHand().getType() == Material.BUCKET && FarmAnimalArmorUtils.isCowArmor(entity.getEquipment().getChestplate())){
                p.getInventory().getItemInMainHand().setType(Material.MILK_BUCKET);
            }
        }
    }
}
