package xyz.roosterseatyou.mobitems.utils.mobarmorutils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;

public class FarmAnimalArmorUtils {
    public static boolean isFarmAnimalArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, Component.text("CLASS ID: FARM_ANIMAL").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC));
    }
}
