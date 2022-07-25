package xyz.roosterseatyou.mobitems.itemstacks.aquatic.axolotl;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class AxolotlLips {
    private static final Component NAME = Component.text("Axolotl Lips");
    public static Component ENTITY_ID = Component.text("ENTITY_ID: AXOLOTL").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static Component CLASS_ID = Component.text("CLASS_ID: AQUATIC").color(TextColor.fromHexString("#2d3233")).decorate(TextDecoration.ITALIC);
    public static ItemStack AXOLOTL_LIPS;

    public static ItemStack init(){
        axolotlLips();
        return null;
    }

    public static void axolotlLips(){
        ItemStack i = ItemUtils.genMobArmor(Material.LEATHER_HELMET, Color.WHITE, NAME, ENTITY_ID, CLASS_ID, 3, EquipmentSlot.HEAD, 5);
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        meta.setColor(ListContainers.getRandAxolotlColor());
        i.setItemMeta(meta);
        AXOLOTL_LIPS = i;
    }
}
