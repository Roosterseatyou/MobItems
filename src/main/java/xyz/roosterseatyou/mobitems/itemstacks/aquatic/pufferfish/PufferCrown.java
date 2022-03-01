package xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class PufferCrown {
    private static final Component NAME = Component.text("Crown of the Pufferfish");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: PUFFERFISH").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack PUFFERFISH_CROWN;

    public static ItemStack init() {
        pufferCrown();
        return null;
    }

    public static void pufferCrown(){
        ItemStack i = ItemUtils.genMobCrown(Material.GOLDEN_HELMET, NAME, ENTITY_ID, CLASS_ID);
        ItemMeta meta = i.getItemMeta();
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        i.setItemMeta(meta);
        PUFFERFISH_CROWN = i;
    }
}
