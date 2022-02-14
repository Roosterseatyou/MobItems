package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

import java.util.List;

public class VillagerUtils {
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

    public static void addProfessionFromStr(ItemStack i, String prof){
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        List<Component> lore = meta.lore();
        switch (prof.toLowerCase()){
            case "weaponsmith":
                assert lore != null;
                lore.add(0, Component.text("Profession: Weaponsmith").color(TextColor.color(255, 255, 255)));
                meta.setColor(Color.GRAY);
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
            case "librarian":
                assert lore != null;
                lore.add(0, Component.text("Profession: Librarian").color(TextColor.color(255, 255, 255)));
                meta.setColor(Color.WHITE);
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
            case "farmer":
                assert lore != null;
                lore.add(0, Component.text("Profession: Farmer").color(TextColor.color(255, 255, 255)));
                meta.lore(lore);
                i.setItemMeta(meta);
                break;
        }
    }

    public static boolean isFarmerArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("Profession: Farmer").color(TextColor.color(255, 255, 255)));
    }

    public static boolean isFarmer(Player p){
        return isFarmerArmor(p.getInventory().getHelmet()) && isFarmerArmor(p.getInventory().getChestplate()) &&
                isFarmerArmor(p.getInventory().getLeggings()) && isFarmerArmor(p.getInventory().getBoots());
    }

    public static boolean isLibArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("Profession: Librarian").color(TextColor.color(255, 255, 255)));
    }

    public static boolean isLibrarian(Player p){
        return isLibArmor(p.getInventory().getHelmet()) && isLibArmor(p.getInventory().getChestplate()) &&
                isLibArmor(p.getInventory().getLeggings()) && isLibArmor(p.getInventory().getBoots());
    }
    public static boolean isWepArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("Profession: Weaponsmith").color(TextColor.color(255, 255, 255)));
    }

    public static boolean isWeaponsmith(Player p){
        return isWepArmor(p.getInventory().getHelmet()) && isWepArmor(p.getInventory().getChestplate()) &&
                isWepArmor(p.getInventory().getLeggings()) && isWepArmor(p.getInventory().getBoots());
    }
}
