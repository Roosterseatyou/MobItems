package xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class VillagerFeet {
    public static Component NAME = Component.text("Villager Feet");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: VILLAGER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: UNDETERMINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack VILLAGER_FEET;

    public static ItemStack init(){
        villagerFeet();
        return null;
    }

    public static void villagerFeet(){
        VILLAGER_FEET = ItemUtils.genMobArmor(Material.LEATHER_BOOTS, Color.MAROON, NAME, ENTITY_ID, CLASS_ID, 5, EquipmentSlot.FEET, 5);
    }
}