package xyz.roosterseatyou.mobitems.itemstacks.undead.zombie;

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

public class ZombieMask {
    public static Component NAME = Component.text("Zombie Mask").color(TextColor.fromHexString("#05540d"));
    public static List<ItemStack> itemsList = new ArrayList<>();
    public static ItemStack ZOMBIE_MASK;

    public static ItemStack init(){
        zombieMask();
        itemsList.add(ZOMBIE_MASK);
        itemsList.add(ZombieChest.ZOMBIE_CHEST);
        itemsList.add(ZombieLegs.ZOMBIE_LEGS);
        itemsList.add(ZombieFeet.ZOMBIE_FEET);
        return null;
    }

    public static void zombieMask(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.setColor(Color.GREEN);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        lore.add(Component.text("Made from the flesh of Zombies..."));
        //see UndeadArmorUtils
        lore.add(Component.text("ENTITY ID: ZOMBIE").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        lore.add(Component.text("CLASS ID: UNDEAD").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
        meta.lore(lore);
        item.setItemMeta(meta);
        ZOMBIE_MASK = item;
    }
}
