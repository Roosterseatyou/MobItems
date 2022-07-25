package xyz.roosterseatyou.mobitems.events.undeadevents.zombie;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class ZombieEvents implements Listener{

    public static boolean isZombieArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("ENTITY ID: ZOMBIE").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }

    public static boolean hasZombieSet(Player p){
        return isZombieArmor(p.getInventory().getHelmet()) && isZombieArmor(p.getInventory().getChestplate())
                && isZombieArmor(p.getInventory().getLeggings()) && isZombieArmor(p.getInventory().getBoots());
    }

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e){
        Entity ent = e.getDamager();
        if (ent instanceof Player){
            Player p = (Player)ent;
            if (hasZombieSet(p)){
                p.setFoodLevel(p.getFoodLevel() + (int)e.getFinalDamage());
            }
        }
    }
}
