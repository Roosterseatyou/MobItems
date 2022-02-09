package xyz.roosterseatyou.mobitems.itemstacks.aquatic.axolotl;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class AxolotlFins {
    private static final Component NAME = Component.text("Axolotl Fins");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: AXOLOTL").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack AXOLOTL_FINS;

    public static ItemStack init(){
        axolotlFins();
        return null;
    }

    public static void axolotlFins(){
        ItemStack i = ItemUtils.genMobArmor(Material.LEATHER_CHESTPLATE, Color.WHITE, NAME, ENTITY_ID, CLASS_ID, 3, EquipmentSlot.CHEST, 5);
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        meta.setColor(ListContainers.getRandAxolotlColor());
        i.setItemMeta(meta);
        AXOLOTL_FINS = i;
    }
}
