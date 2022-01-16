package xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChickenBeak {
    public static Component NAME = Component.text("Chicken Beak");
    public static Component ENTITY_ID = Component.text("ENTITY ID: CHICKEN").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: FARM").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static List<ItemStack> list = new ArrayList<>();
    public static ItemStack CHICKEN_BEAK;

    public static ItemStack init(){
        chickenBeak();
        list.add(CHICKEN_BEAK);
        /*
        list.add(CowChest.COW_CHEST);
        list.add(CowLegs.COW_LEGS);
        list.add(CowHooves.COW_HOOVES);
        */
        return null;
    }

    public static void chickenBeak(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(23, 16, 17));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 1, AttributeModifier.Operation.ADD_NUMBER));
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        CHICKEN_BEAK = item;
    }
}
