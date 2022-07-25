package xyz.roosterseatyou.mobitems.events.nether.strider;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.NetherArmorUtils;

public class StriderListeners implements Listener {
    @EventHandler
    public void onClickPlayer(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Player){
            Player clicked = (Player) e.getRightClicked();
            if(NetherArmorUtils.isStriderArmor(clicked.getInventory().getHelmet())){
                p.addPassenger(clicked);
            }
        }
    }

    //cringe, ik
    @EventHandler
    public void onWalk(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Block b = p.getLocation().getWorld().getBlockAt(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()-1, p.getLocation().getZ()));
        if(NetherArmorUtils.isStriderArmor(p.getInventory().getBoots()) && b.getType() == Material.LAVA){
            b.setType(Material.RED_STAINED_GLASS);
            Bukkit.getScheduler().runTaskLater(MobItems.getInstance(), () -> b.setType(Material.LAVA), 20*15);
        }
    }

    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        if(e.getNewItem() != null && !e.getNewItem().equals(Material.AIR) && NetherArmorUtils.isStriderArmor(e.getNewItem()) && NetherArmorUtils.hasStriderSet(p)){
            PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1);
            p.addPotionEffect(fireRes);
        } else if(e.getOldItem() != null && !e.getOldItem().equals(Material.AIR) && NetherArmorUtils.isStriderArmor(e.getOldItem()) && !NetherArmorUtils.hasStriderSet(p)){
            p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        }
    }
}
