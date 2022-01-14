package xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.checkerframework.checker.units.qual.C;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;

import java.util.ArrayList;
import java.util.List;

public class RabbitMask {
    public static Component NAME = Component.text("Rabbit Mask");
    public static Component ENTITY_ID = Component.text("ENTITY ID: RABBIT").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: UNDEFINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static List<ItemStack> list;
    public static ItemStack RABBIT_MASK;

    public static ItemStack init(){
        rabbitMask();
        list.add(RABBIT_MASK);
        /* adding later
        list.add(RabbitChest.RABBIT_CHEST);
        list.add(RabbitLegs.RABBIT_LEGS);
        list.add(RabbitFeet.RABBIT_FEET);
         */
        return null;
    }

    public static void rabbitMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(23, 16, 17));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        RABBIT_MASK = item;
    }
}
