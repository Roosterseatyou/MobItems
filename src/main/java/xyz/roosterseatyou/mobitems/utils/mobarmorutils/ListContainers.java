package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.glowsquid.GlowSquidTentacles;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.salmon.SalmonFins;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.salmon.SalmonMask;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleChest;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleFeet;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleHead;
import xyz.roosterseatyou.mobitems.itemstacks.aquatic.turtle.TurtleLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenBeak;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenFeet;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenThighs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.chicken.ChickenWings;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.cow.CowMask;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepChest;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepHooves;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepLegs;
import xyz.roosterseatyou.mobitems.itemstacks.farmanimal.sheep.SheepMask;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFace;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedMask;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieChest;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.fox.FoxPaws;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.RabbitMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.snowgolem.SnowGolemMask;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerNose;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

import java.util.ArrayList;
import java.util.Collections;
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

    public static ItemStack genSnow(){
        List<ItemStack> items = new ArrayList<>();
        items.add(SnowGolemMask.SNOW_MASK);
        items.add(SnowGolemChest.SNOW_CHEST);
        items.add(SnowGolemLegs.SNOW_LEGS);
        items.add(SnowGolemFeet.SNOW_FEET);
        return ItemUtils.randomItemStackFromList(items);
    }

    public static ItemStack genUndead(){
        List<ItemStack> itemsList = new ArrayList<>();
        itemsList.add(ZombieMask.ZOMBIE_MASK);
        itemsList.add(ZombieChest.ZOMBIE_CHEST);
        itemsList.add(ZombieLegs.ZOMBIE_LEGS);
        itemsList.add(ZombieFeet.ZOMBIE_FEET);
        return ItemUtils.randomItemStackFromList(itemsList);
    }

    public static ItemStack genVillager(){
        List<ItemStack> list = new ArrayList<>();
        list.add(VillagerNose.VILLAGER_NOSE);
        list.add(VillagerChest.VILLAGER_CHEST);
        list.add(VillagerLegs.VILLAGER_LEGS);
        list.add(VillagerFeet.VILLAGER_FEET);
        return ItemUtils.randomItemStackFromList(list);
    }

    public static ItemStack genMineshaft(){
        List<ItemStack> itemsList = new ArrayList<>();
        itemsList.add(ZombieMask.ZOMBIE_MASK);
        itemsList.add(ZombieChest.ZOMBIE_CHEST);
        itemsList.add(ZombieLegs.ZOMBIE_LEGS);
        itemsList.add(ZombieFeet.ZOMBIE_FEET);
        return ItemUtils.randomItemStackFromList(itemsList);
    }

    public static ItemStack genDungeonArmor(){
        List<ItemStack> itemsList = new ArrayList<>();
        itemsList.add(ZombieMask.ZOMBIE_MASK);
        itemsList.add(ZombieChest.ZOMBIE_CHEST);
        itemsList.add(ZombieLegs.ZOMBIE_LEGS);
        itemsList.add(ZombieFeet.ZOMBIE_FEET);
        return ItemUtils.randomItemStackFromList(itemsList);
    }

    public static EntityType getRandEntity(){
        EntityType[] entityTypes = {EntityType.CREEPER, EntityType.HUSK, EntityType.SPIDER, EntityType.SKELETON, EntityType.STRAY, EntityType.ZOMBIE};
        int to = entityTypes.length - 1;
        return entityTypes[MathUtils.randomIntegerFromRange(0, to)];
    }

    public static ItemStack getRandAquatic(){
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(DrownedMask.DROWNED_MASK);
        itemStacks.add(DrownedChest.DROWNED_CHEST);
        itemStacks.add(DrownedLegs.DROWNED_LEGS);
        itemStacks.add(DrownedFeet.DROWNED_FEET);
        itemStacks.add(SalmonMask.SALMON_LIPS);
        itemStacks.add(SalmonFins.SALMON_FINS);
        itemStacks.add(GlowSquidMask.GLOW_LIPS);
        itemStacks.add(GlowSquidTentacles.GLOW_TENTACLES);
        itemStacks.add(TurtleHead.TURTLE_HEAD);
        itemStacks.add(TurtleChest.TURTLE_CHEST);
        itemStacks.add(TurtleLegs.TURTLE_LEGS);
        itemStacks.add(TurtleFeet.TURTLE_FEET);
        return ItemUtils.randomItemStackFromList(itemStacks);
    }

    public static ItemStack genTaiga(){
        List<ItemStack> list = new ArrayList<>();
        list.add(FoxMask.FOX_MASK);
        list.add(FoxChest.FOX_CHEST);
        list.add(FoxLegs.FOX_LEGS);
        list.add(FoxPaws.FOX_PAWS);
        return ItemUtils.randomItemStackFromList(list);
    }

    public static ItemStack genNether(){
        List<ItemStack> stacks = new ArrayList<>();
        stacks.add(StriderFace.STRIDER_FACE);
        stacks.add(StriderFeet.STRIDER_FEET);
        return ItemUtils.randomItemStackFromList(stacks);
    }

    public static List<Material> bedsList(){
        List<Material> list = new ArrayList<>();
        list.add(Material.WHITE_BED);
        list.add(Material.BLACK_BED);
        list.add(Material.BROWN_BED);
        list.add(Material.GRAY_BED);
        list.add(Material.RED_BED);
        list.add(Material.PINK_BED);
        list.add(Material.ORANGE_BED);
        list.add(Material.YELLOW_BED);
        list.add(Material.GREEN_BED);
        list.add(Material.LIME_BED);
        list.add(Material.CYAN_BED);
        list.add(Material.BLUE_BED);
        list.add(Material.PURPLE_BED);
        list.add(Material.MAGENTA_BED);
        return list;
    }

    public static ItemStack genRandItemFromEntity(EntityType type){
        if(type == EntityType.ZOMBIE){
            return getRandZombieArmor();
        } else if(type == EntityType.DROWNED){
            List<ItemStack> itemStacks = new ArrayList<>();
            itemStacks.add(DrownedMask.DROWNED_MASK);
            itemStacks.add(DrownedChest.DROWNED_CHEST);
            itemStacks.add(DrownedLegs.DROWNED_LEGS);
            itemStacks.add(DrownedFeet.DROWNED_FEET);
            return ItemUtils.randomItemStackFromList(itemStacks);
        } else if (type == EntityType.COW) {
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(CowMask.COW_MASK);
            stacks.add(CowChest.COW_CHEST);
            stacks.add(CowLegs.COW_LEGS);
            stacks.add(CowHooves.COW_HOOVES);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.SHEEP){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(SheepMask.SHEEP_MASK);
            stacks.add(SheepChest.SHEEP_CHEST);
            stacks.add(SheepLegs.SHEEP_LEGS);
            stacks.add(SheepHooves.SHEEP_HOOVES);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.SALMON){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(SalmonMask.SALMON_LIPS);
            stacks.add(SalmonFins.SALMON_FINS);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.FOX){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(FoxMask.FOX_MASK);
            stacks.add(FoxChest.FOX_CHEST);
            stacks.add(FoxLegs.FOX_LEGS);
            stacks.add(FoxPaws.FOX_PAWS);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.CHICKEN){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(ChickenBeak.CHICKEN_BEAK);
            stacks.add(ChickenWings.CHICKEN_WINGS);
            stacks.add(ChickenThighs.CHICKEN_THIGHS);
            stacks.add(ChickenFeet.CHICKEN_FEET);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.RABBIT){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(RabbitMask.RABBIT_MASK);
            stacks.add(RabbitChest.RABBIT_CHEST);
            stacks.add(RabbitLegs.RABBIT_LEGS);
            stacks.add(RabbitFeet.RABBIT_FEET);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.SNOWMAN){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(SnowGolemMask.SNOW_MASK);
            stacks.add(SnowGolemChest.SNOW_CHEST);
            stacks.add(SnowGolemLegs.SNOW_LEGS);
            stacks.add(SnowGolemFeet.SNOW_FEET);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.GLOW_SQUID){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(GlowSquidMask.GLOW_LIPS);
            stacks.add(GlowSquidTentacles.GLOW_TENTACLES);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.TURTLE){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(TurtleHead.TURTLE_HEAD);
            stacks.add(TurtleChest.TURTLE_CHEST);
            stacks.add(TurtleLegs.TURTLE_LEGS);
            stacks.add(TurtleFeet.TURTLE_FEET);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.STRIDER){
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(StriderFace.STRIDER_FACE);
            stacks.add(StriderFeet.STRIDER_FEET);
            return ItemUtils.randomItemStackFromList(stacks);
        } else if(type == EntityType.VILLAGER){
            return genVillager();
        }
        return null;
    }

    public static Component genVillagerProfession(){
        List<Component> list = new ArrayList<>();
        list.add(Component.text("Profession: Librarian").color(TextColor.color(255, 255, 255)));
        list.add(Component.text("Profession: Weaponsmith").color(TextColor.color(255, 255, 255)));
        list.add(Component.text("Profession: Wandering").color(TextColor.color(255, 255, 255)));
        list.add(Component.text("Profession: Farmer").color(TextColor.color(255, 255, 255)));
        return list.get(MathUtils.randomIntegerFromRange(0, list.size()-1));
    }
}
