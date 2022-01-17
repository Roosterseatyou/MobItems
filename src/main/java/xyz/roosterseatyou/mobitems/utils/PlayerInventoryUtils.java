package xyz.roosterseatyou.mobitems.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitMask;

import java.util.List;
import java.util.Objects;

public class PlayerInventoryUtils {
    public static boolean armorEquals(Player p, ItemStack item, EquipmentSlot slot) {
        if (slot.equals(EquipmentSlot.HEAD)) {
            return !(p.getInventory().getHelmet() == null) && p.getInventory().getHelmet() == item;
        } else if (slot.equals(EquipmentSlot.CHEST)) {
            return !(p.getInventory().getChestplate() == null) && p.getInventory().getChestplate() == item;
        } else if (slot.equals(EquipmentSlot.LEGS)) {
            return !(p.getInventory().getLeggings() == null) && p.getInventory().getChestplate() == item;
        } else if (slot.equals(EquipmentSlot.FEET)) {
            return !(p.getInventory().getBoots() == null) && p.getInventory().getBoots() == item;
        }
        return false;
    }
    public static boolean itemInHandEquals(Player p, ItemStack item){
        ItemStack mainHand = p.getInventory().getItemInMainHand();
        return Objects.equals(mainHand, item);
    }
    public static boolean hasID(ItemStack item, Component needed){
        List<Component> lore = item.lore();
        return lore != null && lore.contains(needed);
    }

    public static ItemStack genItemStack(Material mat, Component name, boolean unbreakable){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(name);
        meta.setUnbreakable(unbreakable);
        return item;
    }

    public static ItemStack genLeatherArmor(Material mat, Component name, boolean unbreakable){
        ItemStack item = new ItemStack(mat);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.displayName(name);
        meta.setUnbreakable(unbreakable);
        return item;
    }

    public static boolean isRabbitArmor(ItemStack i){
        return i != null && hasID(i, RabbitMask.ENTITY_ID);
    }
    public static boolean isKillerRabbitArmor(ItemStack i){
        return i != null && hasID(i, KillerRabbitMask.ENTITY_ID);
    }

    public static boolean hasRabbitSet(Player p){
        return isRabbitArmor(p.getInventory().getHelmet()) && isRabbitArmor(p.getInventory().getChestplate())
                && isRabbitArmor(p.getInventory().getLeggings()) && isRabbitArmor(p.getInventory().getBoots());
    }
    public static boolean hasKillerRabbitSet(Player p){
        return isKillerRabbitArmor(p.getInventory().getHelmet()) && isKillerRabbitArmor(p.getInventory().getChestplate())
                && isKillerRabbitArmor(p.getInventory().getLeggings()) && isKillerRabbitArmor(p.getInventory().getBoots());
    }
}
