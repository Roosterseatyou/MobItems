package xyz.roosterseatyou.mobitems.events.hybridevents.drowned;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.events.undeadevents.zombie.ZombieEvents;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedMask;
import xyz.roosterseatyou.mobitems.itemstacks.undead.drowned.DrownedTrident;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.UnderWaterArmorUtils;

public class DrownedEvents implements Listener{

    private EntityDamageEvent.DamageCause damageCause;
    private Block block;

    private static Plugin plugin;
    public DrownedEvents(Plugin plugin){
        DrownedEvents.plugin = plugin;
    }

    public static boolean isDrownedArmor(ItemStack i){
        return PlayerInventoryUtils.hasID(i, Component.text("ENTITY ID: Drowned").color(TextColor.fromHexString("#89E2C7")).decorate(TextDecoration.ITALIC));
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
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE , 125, 2));
                }
            }

        }, 0L, 100L);
    }

    @EventHandler
    public void onRightClick(EntityInteractEvent e){
        Entity ent = e.getEntity();
        block = e.getBlock();
        if (ent instanceof Player && block.getType().equals(Material.WATER)){
            Player p = (Player)ent;
            PlayerInventory inv = p.getInventory();
            if (inv.getItemInMainHand().getType().equals(Material.AIR)){
                inv.setItemInMainHand(DrownedTrident.drownedTrident(UnderWaterArmorUtils.waterLevel(block)));
                p.updateInventory();
                e.getBlock().setType(Material.AIR);
                BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                scheduler.scheduleSyncDelayedTask(plugin, () -> {
                    for (int i = 1; i < 28; i++) {
                        if (inv.getItem(i) != null ) {
                            if (inv.getItem(i).equals(DrownedTrident.drownedTrident(UnderWaterArmorUtils.waterLevel(block)))) {
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
            if (e.getItemDrop().getItemStack().equals(DrownedTrident.drownedTrident(UnderWaterArmorUtils.waterLevel(block)))) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        PlayerInventory inv = e.getWhoClicked().getInventory();
        if (inv.getItem(e.getSlot()) != null && block != null) {
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY) && inv.getItem(e.getSlot()).equals(DrownedTrident.drownedTrident(UnderWaterArmorUtils.waterLevel(block)))) {
                e.setCancelled(true);
            }
        }

    }
}
