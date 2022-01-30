package xyz.roosterseatyou.mobitems.itemstacks.nether.strider;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StriderFace {
    public static Component NAME = Component.text("Strider Face");
    public static Component ENTITY_ID = Component.text("ENTITY ID: STRIDER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: NETHER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack STRIDER_FACE;

    public static ItemStack init(){
        striderFace();
        return null;
    }

    public static void striderFace(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(222, 89, 80));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        STRIDER_FACE = item;
    }
}
