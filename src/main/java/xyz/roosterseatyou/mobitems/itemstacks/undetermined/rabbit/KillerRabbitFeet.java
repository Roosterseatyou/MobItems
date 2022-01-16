package xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KillerRabbitFeet {
    public static Component NAME = Component.text("Killer Rabbit Claws");
    public static Component ENTITY_ID = Component.text("ENTITY ID: KILLER_RABBIT").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: UNDEFINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack RABBIT_FEET;

    public static ItemStack init(){
        rabbitFeet();
        return null;
    }

    public static void rabbitFeet(){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", 5, AttributeModifier.Operation.ADD_NUMBER));
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        RABBIT_FEET = item;
    }
}
