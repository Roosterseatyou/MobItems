package xyz.roosterseatyou.mobitems.itemstacks.undead.drowned;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.checkerframework.checker.units.qual.C;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

import java.util.List;

public class DrownedFeet {
    public static Component NAME = Component.text("Drowned Feet").color(TextColor.fromHexString("#2d3233"));
    public static ItemStack DROWNED_FEET;
    public static Component CLASS_ID = Component.text("CLASS ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component ENTITY_ID = Component.text("ENTITY ID: DROWNED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID_ONE = Component.text("CLASS ID: UNDEAD").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);

    public static ItemStack init(){
        drownedFeet();
        return null;
    }

    public static void drownedFeet(){
        ItemStack item = ItemUtils.genMobArmor(Material.LEATHER_BOOTS, Color.AQUA, NAME, ENTITY_ID, CLASS_ID_ONE, 5, EquipmentSlot.FEET, 5);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = meta.lore();
        meta.setColor(Color.fromRGB(54, 89, 78));
        assert lore != null;
        lore.add(Component.text("Ironically, you now know how to swim..."));
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        lore.add(CLASS_ID_ONE);
        meta.lore(lore);
        item.setItemMeta(meta);
        DROWNED_FEET= item;
    }
}
