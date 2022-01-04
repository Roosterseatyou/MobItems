package xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep;

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

public class SheepLegs {
    public static Component NAME = Component.text("Sheep Leggings");
    public static ItemStack SHEEP_LEGS;

    public static ItemStack init(){
        sheepLeggings();
        return null;
    }

    public static void sheepLeggings(){
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.WHITE);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        lore.add(Component.text("Beep beep, I'm a Sheep..."));
        //see FarmAnimalArmorUtils
        lore.add(Component.text("ENTITY ID: SHEEP").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        lore.add(Component.text("CLASS ID: FARM").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        meta.lore(lore);
        item.setItemMeta(meta);
        SHEEP_LEGS = item;
    }
}
