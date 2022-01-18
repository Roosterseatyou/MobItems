package xyz.roosterseatyou.mobitems.itemstacks.undead.drowned;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DrownedTrident {
    public static Component NAME = Component.text("Three Pronged Thingamajig").color(TextColor.fromHexString("#89E2C7"));


    public static ItemStack drownedTrident(int level) {
        ItemStack item = new ItemStack(Material.TRIDENT);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        if (level > 3) {
            meta.addEnchant(Enchantment.RIPTIDE, level-3, true);
        }
        if (level > 1) {
            meta.addEnchant(Enchantment.IMPALING, level-1, true);
            meta.addEnchant(Enchantment.DAMAGE_ALL, level-1, true);
        }
        lore.add(Component.text("Your newfound aquatic affinity coalesces into something more physical..."));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
