package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class UndeadArmorUtils {
    public static boolean isUndeadArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, Component.text("CLASS ID: UNDEAD").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }

    public static boolean hasFullSet(Player p) {
        return isUndeadArmor(p.getInventory().getHelmet()) && isUndeadArmor(p.getInventory().getChestplate())
                && isUndeadArmor(p.getInventory().getLeggings()) && isUndeadArmor(p.getInventory().getBoots());
    }




    public static boolean inSunlight(Player p){
        Block block = p.getLocation().getBlock().getRelative(0, 1, 0);
        int sunlightLevel = block.getLightFromSky();
        return sunlightLevel == 15 && day(p);
    }
    public static boolean day(Player p) {
        long time = p.getWorld().getTime();
        return time > 0 && time < 12300;
    }
}
