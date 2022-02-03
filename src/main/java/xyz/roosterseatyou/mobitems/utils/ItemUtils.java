package xyz.roosterseatyou.mobitems.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ItemUtils{

    public static ItemStack randomItemStackFromList(List<ItemStack> list){
        int rIndex = MathUtils.randomIntegerFromRange(0, list.size()-1);
        return list.get(rIndex);
    }

    public static void ApplyDamage(ItemStack tool, int damageDealt){
        Damageable item = (Damageable) tool.getItemMeta();

        item.setDamage(item.getDamage() + damageDealt);
    }

    public static ItemStack genMobArmor(Material mat, Component name, Component entityID, Component classID, int strength, EquipmentSlot slotType, int unbreakingVal){
        ItemStack i = new ItemStack(mat);
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        meta.displayName(name);
        List<Component> lore = new ArrayList<>();
        lore.add(entityID);
        lore.add(classID);
        meta.addEnchant(Enchantment.DURABILITY, unbreakingVal, true);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", strength, AttributeModifier.Operation.ADD_NUMBER, slotType));
        meta.lore(lore);
        i.setItemMeta(meta);
        return i;
    }

}