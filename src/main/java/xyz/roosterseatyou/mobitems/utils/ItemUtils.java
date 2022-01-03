package xyz.roosterseatyou.mobitems.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;


public class ItemUtils{

    public static void ApplyDamage(ItemStack tool, int damageDealt){
        Damageable item = (Damageable) tool.getItemMeta();

        item.setDamage(item.getDamage() + damageDealt);
    }

}