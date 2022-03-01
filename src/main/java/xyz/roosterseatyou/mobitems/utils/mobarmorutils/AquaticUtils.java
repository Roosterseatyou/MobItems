package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.axolotl.AxolotlCrown;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidRing;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish.PufferCrown;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.salmon.SalmonMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleHead;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedFeet;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

import java.util.ArrayList;
import java.util.List;

public class AquaticUtils {
    public static boolean isAquaticArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, DrownedFeet.CLASS_ID);
    }
    public static boolean hasFullSet(Player p) {
        return  isAquaticArmor(p.getInventory().getHelmet()) && isAquaticArmor(p.getInventory().getChestplate())
                && isAquaticArmor(p.getInventory().getLeggings()) && isAquaticArmor(p.getInventory().getBoots());
    }

    public static boolean isSalmonArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, SalmonMask.ENTITY_ID);
    }

    public static boolean hasSalmonSet(Player p) {
        return isSalmonArmor(p.getInventory().getHelmet()) && isSalmonArmor(p.getInventory().getBoots());
    }

    public static boolean hasGlowRing(Player p) {
        PlayerInventory inv = p.getInventory();
        List<ItemStack> iList = new ArrayList<>();
        int index = 0;
        for(ItemStack i : inv){
            if(index < 9) {
                index++;
                iList.add(i);
            } else {
                break;
            }
        }
        boolean flag = false;
        for(ItemStack i : iList) {
            flag = PlayerInventoryUtils.hasID(i, GlowSquidRing.ENTITY_ID);
            if(flag) break;

        }
        return flag;
    }

    public static boolean isTurtArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, TurtleHead.ENTITY_ID);
    }

    public static boolean hasTurtSet(Player p){
        return  isTurtArmor(p.getInventory().getHelmet()) && isTurtArmor(p.getInventory().getChestplate()) &&
                isTurtArmor(p.getInventory().getLeggings()) && isTurtArmor(p.getInventory().getBoots());
    }

    public static boolean isPufferArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, PufferCrown.ENTITY_ID);
    }

    public static boolean hasPufferCrown(Player p){
        return isPufferArmor(p.getInventory().getHelmet());
    }

    public static boolean hasAxolotlCrown(Player p) {
        return p.getInventory().getHelmet() != null && PlayerInventoryUtils.hasID(p.getInventory().getHelmet(), AxolotlCrown.ENTITY_ID);
    }

    public static int getTurtArmorCount(Player p){
        int amt = 0;
        for(ItemStack i : p.getInventory().getArmorContents()){
            if(isTurtArmor(i)){
                amt++;
            }
        }
        return amt;
    }

    public static int waterLevel(Block b){
        int level = 0;
        for (int i = -1; i < 2; i += 2){
            Block block = b.getRelative(i, 0, 0);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
            block = b.getRelative(0, i, 0);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
            block = b.getRelative(0, 0, i);
            if (block.getType().equals(Material.WATER)){
                level++;
            }
        }
        return level;
    }
}
