package xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChickenWings {
    public static Component NAME = Component.text("Chicken Wings");
    public static ItemStack CHICKEN_WINGS;

    public static ItemStack init(){
        chickenWings();
        return null;
    }

    public static void chickenWings(){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.WHITE);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 2, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        //see FarmAnimalArmorUtils
        lore.add(ChickenBeak.ENTITY_ID);
        lore.add(ChickenBeak.CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        CHICKEN_WINGS = item;
    }
}
