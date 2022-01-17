package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

import java.util.ArrayList;
import java.util.List;

public class ListContainers {
    public static ItemStack getRandZombieArmor(){
        List<ItemStack> itemsList = new ArrayList<>();
        itemsList.add(ZombieMask.ZOMBIE_MASK);
        itemsList.add(ZombieChest.ZOMBIE_CHEST);
        itemsList.add(ZombieLegs.ZOMBIE_LEGS);
        itemsList.add(ZombieFeet.ZOMBIE_FEET);
        return ItemUtils.randomItemStackFromList(itemsList);
    }

}
