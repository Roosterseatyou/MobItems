package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class FarmAnimalArmorUtils {

    public static boolean isFarmAnimalArmor(ItemStack i) {
        return PlayerInventoryUtils.hasID(i, SheepMask.CLASS_ID);
    }

    public static boolean hasFullSet(Player p) {
        return isFarmAnimalArmor(p.getInventory().getHelmet()) && isFarmAnimalArmor(p.getInventory().getChestplate())
                && isFarmAnimalArmor(p.getInventory().getLeggings()) && isFarmAnimalArmor(p.getInventory().getBoots());
    }

    public static boolean isSheepSet(Player p){
        return p.getInventory().getHelmet() != null && PlayerInventoryUtils.hasID(p.getInventory().getHelmet(), SheepMask.ENTITY_ID) && p.getInventory().getChestplate() != null && PlayerInventoryUtils.hasID(p.getInventory().getChestplate(), SheepMask.ENTITY_ID)
                && p.getInventory().getLeggings() != null && PlayerInventoryUtils.hasID(p.getInventory().getLeggings(), SheepMask.ENTITY_ID) && p.getInventory().getBoots() != null && PlayerInventoryUtils.hasID(p.getInventory().getBoots(), SheepMask.ENTITY_ID);
    }
}
