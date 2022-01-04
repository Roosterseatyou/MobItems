package xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class CowLegs {
    public static Component NAME = Component.text("Cow Leggings");
    public static ItemStack COW_LEGS;

    public static ItemStack init(){
        cowLegs();
        return null;
    }

    public static void cowLegs(){
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(23, 16, 17));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        lore.add(Component.text("Meow Meow, I'm A Cow..."));
        //see FarmAnimalArmorUtils
        lore.add(Component.text("ENTITY ID: COW").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        lore.add(Component.text("CLASS ID: FARM").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        meta.lore(lore);
        item.setItemMeta(meta);
        COW_LEGS = item;
    }
}
