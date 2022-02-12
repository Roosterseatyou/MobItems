package xyz.roosterseatyou.mobitems.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;


public class ItemUtils{

    public static ItemStack randomItemStackFromList(@NotNull List<ItemStack> list){
        int rIndex = MathUtils.randomIntegerFromRange(0, list.size()-1);
        return list.get(rIndex);
    }

    public static void ApplyDamage(@NotNull ItemStack tool, int damageDealt){
        Damageable item = (Damageable) tool.getItemMeta();

        item.setDamage(item.getDamage() + damageDealt);
    }

    public static @NotNull ItemStack genMobArmor(Material mat, Color color , Component name, Component entityID, Component classID, int strength, EquipmentSlot slotType, int unbreakingVal){
        ItemStack i = new ItemStack(mat);
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        meta.displayName(name);
        List<Component> lore = new ArrayList<>();
        lore.add(entityID);
        lore.add(classID);
        meta.setColor(color);
        meta.addEnchant(Enchantment.DURABILITY, unbreakingVal, true);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "gen_armor", strength, AttributeModifier.Operation.ADD_NUMBER, slotType));
        meta.lore(lore);
        i.setItemMeta(meta);
        return i;
    }

    public static void addRandProfession(@NotNull ItemStack i){
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        List<Component> lore = meta.lore();
        assert lore != null;
        lore.add(ListContainers.genVillagerProfession());
        meta.lore(lore);
        i.setItemMeta(meta);
    }

    /*Fun fact, I spent over 4 hours staring at this code, wondering why it was adding more than one profession tag,
        only to realize there were no break statements ANYWHERE IN THERE.
    */

    public static void addProfessionFromVill(ItemStack i, Villager v){
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        List<Component> lore = meta.lore();
        switch (v.getProfession()){
            case WEAPONSMITH:
                assert lore != null;
                lore.add(0, Component.text("Profession: Weaponsmith").color(TextColor.color(255, 255, 255)));
                meta.setColor(Color.GRAY);
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
            case LIBRARIAN:
                assert lore != null;
                lore.add(0, Component.text("Profession: Librarian").color(TextColor.color(255, 255, 255)));
                meta.setColor(Color.WHITE);
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
            case FARMER:
                assert lore != null;
                lore.add(0, Component.text("Profession: Farmer").color(TextColor.color(255, 255, 255)));
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
        }
    }
}