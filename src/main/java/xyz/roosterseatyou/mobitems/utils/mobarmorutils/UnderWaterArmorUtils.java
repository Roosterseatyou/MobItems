package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class  UnderWaterArmorUtils {
    public static boolean isUnderWaterArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, Component.text("CLASS ID: UNDERWATER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }
    public static boolean hasFullSet(Player p) {
        return p.getInventory().getHelmet() != null &&  p.getInventory().getChestplate() != null &&
                p.getInventory().getLeggings() != null &&  p.getInventory().getBoots() != null && isUnderWaterArmor(p.getInventory().getHelmet()) && isUnderWaterArmor(p.getInventory().getChestplate())
                && isUnderWaterArmor(p.getInventory().getLeggings()) && isUnderWaterArmor(p.getInventory().getBoots());
    }

    public static int waterLevel(Block b){
        int level = 0;
        for (int i = -1; i < 2; i += 2){
            Block block = b.getRelative(i, 0, 0);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
            block = b.getRelative(0, i, 0);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
            block = b.getRelative(0, 0, i);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
        }
        return level;
    }
}
