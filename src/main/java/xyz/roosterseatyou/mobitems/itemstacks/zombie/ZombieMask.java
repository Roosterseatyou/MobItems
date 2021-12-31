package xyz.roosterseatyou.mobitems.itemstacks.zombie;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.MathHelpers;
import xyz.roosterseatyou.pluginlibrary.PlayerInventoryUtils;

public class ZombieMask {
    public static ItemStack ZOMBIE_MASK;

    public static ItemStack init(){
        return null;
    }

    public static void zombieMask(){
        ItemStack item = PlayerInventoryUtils.genLeatherArmor(Material.LEATHER_HELMET, Component.text("S"), true);
    }
}
