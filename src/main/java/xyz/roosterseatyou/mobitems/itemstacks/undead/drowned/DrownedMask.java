package xyz.roosterseatyou.mobitems.itemstacks.undead.drowned;

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

public class DrownedMask {
    public static Component NAME = Component.text("Drowned Mask").color(TextColor.fromHexString("#89E2C7"));
    public static List<ItemStack> list = new ArrayList<>();
    public static ItemStack DROWNED_MASK;

    public static ItemStack init(){
        drownedMask();
        list.add(DrownedMask.DROWNED_MASK);
        list.add(DrownedChest.DROWNED_CHEST);
        list.add(DrownedLegs.DROWNED_LEGS);
        list.add(DrownedFeet.DROWNED_FEET);
        return null;
    }

    public static void drownedMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(54, 89, 78));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        lore.add(Component.text("Ironically, you now know how to swim..."));
        //see UndeadArmorUtils & AquaticUtils
        lore.add(Component.text("ENTITY ID: Drowned").color(TextColor.fromHexString("#89E2C7")).decorate(TextDecoration.ITALIC));
        lore.add(Component.text("CLASS ID: UNDEAD").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        lore.add(Component.text("CLASS ID: AQUATIC").color(TextColor.fromHexString("#92D2E2")).decorate(TextDecoration.ITALIC));
        meta.lore(lore);
        item.setItemMeta(meta);
        DROWNED_MASK = item;
    }
}