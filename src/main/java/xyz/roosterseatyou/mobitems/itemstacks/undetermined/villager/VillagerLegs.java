package xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class VillagerLegs {
    public static Component NAME = Component.text("Villager Leggings");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: VILLAGER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: UNDETERMINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack VILLAGER_LEGS;

    public static ItemStack init(){
        villagerLeggings();
        return null;
    }

    public static void villagerLeggings(){
        VILLAGER_LEGS = ItemUtils.genMobArmor(Material.LEATHER_LEGGINGS, NAME, ENTITY_ID, CLASS_ID, 5, EquipmentSlot.LEGS, 5);
    }
}
