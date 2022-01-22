package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenBeak;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class FarmAnimalArmorUtils {

    public static boolean isFarmAnimalArmor(ItemStack i) {
        return i != null && PlayerInventoryUtils.hasID(i, SheepMask.CLASS_ID);
    }

    public static boolean isSheepArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("ENTITY ID: SHEEP").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }

    public static boolean hasFullSet(Player p) {
        return isFarmAnimalArmor(p.getInventory().getHelmet()) && isFarmAnimalArmor(p.getInventory().getChestplate())
                && isFarmAnimalArmor(p.getInventory().getLeggings()) && isFarmAnimalArmor(p.getInventory().getBoots());
    }

    public static boolean isSheepSet(Player p){
        return p.getInventory().getHelmet() != null && PlayerInventoryUtils.hasID(p.getInventory().getHelmet(), SheepMask.ENTITY_ID) && p.getInventory().getChestplate() != null && PlayerInventoryUtils.hasID(p.getInventory().getChestplate(), SheepMask.ENTITY_ID)
                && p.getInventory().getLeggings() != null && PlayerInventoryUtils.hasID(p.getInventory().getLeggings(), SheepMask.ENTITY_ID) && p.getInventory().getBoots() != null && PlayerInventoryUtils.hasID(p.getInventory().getBoots(), SheepMask.ENTITY_ID);
    }

    public static boolean isCowArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, CowMask.ENTITY_ID);
    }

    public static boolean isCowSet(Player p){
        return p.getInventory().getHelmet() != null && PlayerInventoryUtils.hasID(p.getInventory().getHelmet(), CowMask.ENTITY_ID) && p.getInventory().getChestplate() != null && PlayerInventoryUtils.hasID(p.getInventory().getChestplate(), CowMask.ENTITY_ID)
                && p.getInventory().getLeggings() != null && PlayerInventoryUtils.hasID(p.getInventory().getLeggings(), CowMask.ENTITY_ID) && p.getInventory().getBoots() != null && PlayerInventoryUtils.hasID(p.getInventory().getBoots(), CowMask.ENTITY_ID);
    }

    public static boolean isChickenArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, ChickenBeak.ENTITY_ID);
    }

    public static boolean hasChickenSet(Player p){
        return isChickenArmor(p.getInventory().getHelmet()) && isChickenArmor(p.getInventory().getChestplate()) &&
                isChickenArmor(p.getInventory().getLeggings()) &&isChickenArmor(p.getInventory().getBoots());
    }
}
