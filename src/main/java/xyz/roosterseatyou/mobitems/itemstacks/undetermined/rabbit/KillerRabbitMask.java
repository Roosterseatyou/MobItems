package xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit;

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

public class KillerRabbitMask {
    public static Component NAME = Component.text("Killer Rabbit Fangs");
    public static Component ENTITY_ID = Component.text("ENTITY ID: KILLER_RABBIT").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS ID: UNDEFINED").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static List<ItemStack> list = new ArrayList<>();
    public static ItemStack RABBIT_MASK;

    public static ItemStack init(){
        rabbitMask();
        list.add(RABBIT_MASK);
        list.add(KillerRabbitChest.RABBIT_CHEST);
        list.add(KillerRabbitLegs.RABBIT_LEGS);
        list.add(KillerRabbitFeet.RABBIT_FEET);
        return null;
    }

    public static void rabbitMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Stained with the Blood of the Moon"));
        meta.displayName(NAME);
        meta.setColor(Color.MAROON);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        //see FarmAnimalArmorUtils
        lore.add(ENTITY_ID);
        lore.add(CLASS_ID);
        meta.lore(lore);
        item.setItemMeta(meta);
        RABBIT_MASK = item;
    }
}
