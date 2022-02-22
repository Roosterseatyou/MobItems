package xyz.roosterseatyou.mobitems.itemstacks.tamable.horse;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class HorseRing {
    private static final Component NAME = Component.text("Crown of Horses");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: HORSE").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: TAMABLE").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack HORSE_RING;

    public static ItemStack init(){
        horseRing();
        return null;
    }

    public static void horseRing(){
        HORSE_RING = ItemUtils.genMobCrown(Material.GOLD_NUGGET, NAME, ENTITY_ID, CLASS_ID);
    }
}
