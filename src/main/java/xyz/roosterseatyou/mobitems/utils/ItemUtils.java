package xyz.roosterseatyou.mobitems.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.List;


public class ItemUtils{

    public static ItemStack randomItemStackFromList(List<ItemStack> list){
        int rIndex = MathUtils.randomIntegerFromRange(0, list.size());
        return list.get(rIndex);
    }

    public static void ApplyDamage(ItemStack tool, int damageDealt){
        Damageable item = (Damageable) tool.getItemMeta();

        item.setDamage(item.getDamage() + damageDealt);
    }

}