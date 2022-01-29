package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.salmon.SalmonMask;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class AquaticUtils {
    public static boolean isAquaticArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("CLASS ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }
    public static boolean hasFullSet(Player p) {
        return  isAquaticArmor(p.getInventory().getHelmet()) && isAquaticArmor(p.getInventory().getChestplate())
                && isAquaticArmor(p.getInventory().getLeggings()) && isAquaticArmor(p.getInventory().getBoots());
    }

    public static boolean isSalmonArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, SalmonMask.ENTITY_ID);
    }

    public static boolean hasSalmonSet(Player p) {
        return  isSalmonArmor(p.getInventory().getHelmet()) && isSalmonArmor(p.getInventory().getChestplate())
                && isSalmonArmor(p.getInventory().getLeggings()) && isSalmonArmor(p.getInventory().getBoots());
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
