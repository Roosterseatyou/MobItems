package xyz.roosterseatyou.mobitems.events.farmanimalevents.sheep;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.FarmAnimalArmorUtils;

import java.util.HashMap;

public class SheepListeners implements Listener {
    public static HashMap<Player, Long> cooldown = new HashMap<>();
    public static HashMap<Player, Boolean> woolState = new HashMap<>();
    //is used in FarmAnimalEvents

    @EventHandler
    public static void onPlayerRightClick(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();
        if(entity instanceof Player){
            Player clicked = (Player) entity;
            if(clicked.getInventory().getChestplate() != null && PlayerInventoryUtils.hasID(clicked.getInventory().getChestplate(), Component.text("ENTITY ID: SHEEP").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC))
                && clicked.getInventory().getLeggings() != null && PlayerInventoryUtils.hasID(clicked.getInventory().getLeggings(), Component.text("ENTITY ID: SHEEP").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC))
                    && !p.getInventory().getItemInMainHand().equals(new ItemStack(Material.AIR)) && p.getInventory().getItemInMainHand().equals(new ItemStack(Material.SHEARS))){
                if(cooldown.get(p) >= (System.currentTimeMillis()/1000) + 120) {
                    Location loc = clicked.getLocation();
                    loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WHITE_WOOL, MathUtils.randomIntegerFromRange(1, 4)));
                    cooldown.put(p, (System.currentTimeMillis()/1000));
                }else{
                    p.sendActionBar(Component.text("You still have to wait " + cooldown.get(p) + " to shear " + p.getName() + "!"));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerArmor(PlayerArmorChangeEvent e){
        Player p = e.getPlayer();
        if(FarmAnimalArmorUtils.isSheepSet(p)){
            if(!woolState.get(p)){
                woolState.put(p, true);
            }
        }
    }
}
