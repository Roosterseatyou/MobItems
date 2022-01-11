package xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import xyz.roosterseatyou.mobitems.events.farmanimalevents.cow.CowListeners;

import java.util.ArrayList;
import java.util.List;

public class CowMask {
    public static Component NAME = Component.text("Cow Mask");
    public static List<ItemStack> list;
    public static ItemStack COW_MASK;

    public static ItemStack init(){
        cowMask();
        list.add(CowMask.COW_MASK);
        list.add(CowChest.COW_CHEST);
        list.add(CowLegs.COW_LEGS);
        list.add(CowHooves.COW_HOOVES);
        return null;
    }

    public static void cowMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
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
        COW_MASK = item;
    }
}
