package xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class GlowSquidRing {
    public static Component NAME = Component.text("Glow Squid Ring");
    public static Component ENTITY_ID = Component.text("ENTITY ID: GLOW_SQUID").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack GLOW_RING;

    public static ItemStack init(){
        glowRing();
        return null;
    }

    public static void glowRing(){
        ItemStack i = ItemUtils.genMobCrown(Material.GOLD_NUGGET, NAME, ENTITY_ID, CLASS_ID);
        ItemMeta meta = i.getItemMeta();
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        i.setItemMeta(meta);
        GLOW_RING = i;
    }
}