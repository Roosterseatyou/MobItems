package xyz.roosterseatyou.mobitems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class FarmingUtils {
    public static void replantCrop(Location loc, Material seed, Plugin plugin){
        Bukkit.getScheduler().runTaskLater(plugin, () -> loc.getBlock().setType(seed), 20L);
    }

    public static void removeSeed(Player p, Material seedMat){
        int seedIndexLocation = -1;
        ItemStack currentItems;
        PlayerInventory pInv = p.getInventory();

        for(int slotIndex = 0; slotIndex <= pInv.getSize(); slotIndex++){
            currentItems = pInv.getItem(slotIndex);
            if(currentItems != null){
                if(currentItems.getType() == seedMat){
                    seedIndexLocation =slotIndex;

                    slotIndex = pInv.getSize();
                }
            }
        }
        if(seedIndexLocation != -1){
            ItemStack seedItemStack = pInv.getItem(seedIndexLocation);
            if(seedItemStack != null){
                int seedAmt = seedItemStack.getAmount();
                seedItemStack.setAmount(seedAmt - 1);
            }
        }
    }
    public static boolean isSeedInInv(Player p, Material mat){
        PlayerInventory pInv = p.getInventory();
        if (mat == Material.WHEAT) {
            return pInv.contains(Material.WHEAT_SEEDS);
        } else if (mat == Material.POTATOES) {
            return pInv.contains(Material.POTATO);
        } else if (mat == Material.CARROTS) {
            return pInv.contains(Material.CARROT);
        } else if (mat == Material.BEETROOTS) {
            return pInv.contains(Material.BEETROOT);
        } else if (mat == Material.NETHER_WART) {
            return pInv.contains(Material.NETHER_WART);
        }
        return false;
    }
    public static Material getSeeds(Material mat) {
        if (mat == Material.WHEAT) {
            return Material.WHEAT;
        } else if (mat == Material.POTATOES) {
            return Material.POTATOES;
        } else if (mat == Material.CARROTS) {
            return Material.CARROTS;
        } else if (mat == Material.BEETROOTS) {
            return Material.BEETROOTS;
        } else if (mat == Material.NETHER_WART) {
            return Material.NETHER_WART;
        }
        return null;
    }
    public static boolean isFullyGrown(Block b) {
        Ageable ageable = (Ageable) b.getBlockData();
        int maxAge = ageable.getMaximumAge();

        return ageable.getAge() == maxAge;

    }
    public static boolean isCrop(Block b){
        return b.getType() == Material.WHEAT || b.getType() == Material.CARROTS || b.getType() == Material.BEETROOTS || b.getType() == Material.POTATOES;
    }
}
