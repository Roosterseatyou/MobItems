package xyz.roosterseatyou.mobitems.itemstacks.aquatic.pufferfish;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;

public class PufferfishChest {
    private static final Component NAME = Component.text("Pufferfish Fins");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: PUFFERFISH").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack PUFFER_FINS;

    public static ItemStack init(){
        pufferChest();
        return null;
    }

    public static void pufferChest(){
        PUFFER_FINS = ItemUtils.genMobArmor(Material.LEATHER_CHESTPLATE, Color.YELLOW, NAME, ENTITY_ID, CLASS_ID, 3, EquipmentSlot.CHEST, 5);
    }
}
