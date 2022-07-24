package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.itemstacks.nether.strider.StriderFace;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class NetherArmorUtils {
    //WILL ALL BE REMOVED IN THE FUTURE
    public static boolean isNetherArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("CLASS ID: NETHER").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }

    public static boolean isStriderArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, StriderFace.ENTITY_ID);
    }

    public static boolean hasStriderSet(Player p){
        return isStriderArmor(p.getInventory().getHelmet()) && isStriderArmor(p.getInventory().getBoots());
    }
}
