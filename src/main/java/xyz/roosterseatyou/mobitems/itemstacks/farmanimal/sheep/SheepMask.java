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

public class SheepMask {
    public static Component ENTITY_ID = Component.text("ENTITY ID: SHEEP").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: FARM").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component NAME = Component.text("Sheep Mask");
    public static List<ItemStack> list = new ArrayList<>();
    public static ItemStack SHEEP_MASK;

    public static ItemStack init(){
        sheepMask();
        list.add(SHEEP_MASK);
        list.add(SheepChest.SHEEP_CHEST);
        list.add(SheepLegs.SHEEP_LEGS);
        list.add(SheepHooves.SHEEP_HOOVES);
        return null;
    }

    public static void sheepMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.WHITE);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        lore.add(Component.text("Beep beep, I'm a Sheep..."));
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        SHEEP_MASK = item;
    }
}
