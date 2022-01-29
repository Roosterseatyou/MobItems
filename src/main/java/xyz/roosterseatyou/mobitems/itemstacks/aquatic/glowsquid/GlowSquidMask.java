package xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid;

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

public class GlowSquidMask {
    public static Component NAME = Component.text("Glow Squid Lips");
    public static Component ENTITY_ID = Component.text("ENTITY ID: GLOW_SQUID").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack GLOW_LIPS;

    public static ItemStack init(){
        glowLips();
        return null;
    }

    public static void glowLips(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(14, 232, 138));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        //see AquaticUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        GLOW_LIPS = item;
    }
}
