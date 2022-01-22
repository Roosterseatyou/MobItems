package xyz.roosterseatyou.mobitems.events.hybridevents.drowned;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.events.undeadevents.zombie.ZombieEvents;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedMask;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UnderWaterArmorUtils;

import java.util.ArrayList;
import java.util.List;

public class DrownedEvents implements Listener{
    private static ItemStack trident;
    private EntityDamageEvent.DamageCause damageCause;
    private Block block;

    private static Plugin plugin;
    public DrownedEvents(Plugin plugin){
        DrownedEvents.plugin = plugin;
    }

    public static boolean isDrownedArmor(ItemStack i){
        return i != null && PlayerInventoryUtils.hasID(i, Component.text("ENTITY ID: Drowned").color(TextColor.fromHexString("#89E2C7")).decorate(TextDecoration.ITALIC));
    }

    public static boolean hasDrownedSet(Player p) {
        return isDrownedArmor(p.getInventory().getHelmet()) && isDrownedArmor(p.getInventory().getChestplate())
                && isDrownedArmor(p.getInventory().getLeggings()) && isDrownedArmor(p.getInventory().getBoots());
    }
    
    @EventHandler
    public void getDamageCause(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            damageCause = e.getCause();
        }
    }
    

    @EventHandler(priority = EventPriority.HIGH)
    public void turned(PlayerDeathEvent e){
        Player p = e.getPlayer();
        if (damageCause.equals(EntityDamageEvent.DamageCause.DROWNING) && ZombieEvents.hasZombieSet(p) ){
            PlayerInventory inv = p.getInventory();
            inv.setArmorContents(DrownedMask.list.toArray(new ItemStack[0]));
            p.updateInventory();
        }
    }

    public static void waterPowers(){
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()){
                if (hasDrownedSet(p) && p.isInWaterOrBubbleColumn()){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE , 125, 1));
                }
            }

        }, 0L, 100L);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        block = p.getLocation().getBlock();
        if (block.getType().equals(Material.WATER) && hasDrownedSet(p)){
            PlayerInventory inv = p.getInventory();
            if (inv.getItemInMainHand().getType().equals(Material.AIR)){
                trident = drownedTrident(UnderWaterArmorUtils.waterLevel(block));
                inv.setItemInMainHand(trident);
                p.updateInventory();
                e.getClickedBlock().setType(Material.AIR);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, () -> {
                    for (int i = 1; i < 28; i++) {
                        if (inv.getItem(i) != null ) {
                            if (inv.getItem(i).equals(trident)) {
                                inv.setItem(i, new ItemStack(Material.AIR));
                                p.updateInventory();
                            }
                        }
                    }
                }, 3000);
            }
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if (block != null) {
            if (e.getItemDrop().getItemStack().equals(trident)) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        PlayerInventory inv = e.getWhoClicked().getInventory();
        if (inv.getItem(e.getSlot()) != null && block != null) {
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY) && inv.getItem(e.getSlot()).equals(trident)) {
                e.setCancelled(true);
            }
        }

    }

    private static final Component NAME = Component.text("Three Pronged Thingamajig").color(TextColor.fromHexString("#89E2C7"));

    public static ItemStack drownedTrident(int level) {
        ItemStack item = new ItemStack(Material.TRIDENT);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(NAME);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        if (level > 3) {
            meta.addEnchant(Enchantment.RIPTIDE, level-3, true);
        }
        if (level > 1) {
            meta.addEnchant(Enchantment.IMPALING, level-1, true);
            meta.addEnchant(Enchantment.DAMAGE_ALL, level-1, true);
        }
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        lore.add(Component.text("Your newfound aquatic affinity coalesces"));
        lore.add(Component.text("into something more physical..."));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
