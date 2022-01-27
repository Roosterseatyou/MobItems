package xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SnowGolemChest {
    public static Component NAME = Component.text("Snowman Chestplate");
    public static Component ENTITY_ID = Component.text("ENTITY ID: SNOW_GOLEM").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: UNDEFINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack SNOW_CHEST;

    public static ItemStack init(){
        snowChest();
        return null;
    }

    public static void snowChest(){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 4, AttributeModifier.Operation.ADD_NUMBER));
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        SNOW_CHEST = item;
    }
}