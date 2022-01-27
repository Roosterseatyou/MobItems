package xyz.roosterseatyou.mobitems.events.hybridevents.drowned;


import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
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
import org.bukkit.event.player.PlayerQuitEvent;
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
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.AquaticUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrownedEvents implements Listener{
    private EntityDamageEvent.DamageCause damageCause;
    private Block block;
    private static final HashMap<Player, ItemStack> playerStackMap = new HashMap<>();
    private static final HashMap<Player, Long> cooldown = new HashMap<>();
    private static final HashMap<Player, Boolean> canClaim = new HashMap<>();
    private static final HashMap<Player, Boolean> needsTaking = new HashMap<>();

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
    public void armorChange(PlayerArmorChangeEvent e){
        ItemStack newItem = e.getNewItem();
        ItemStack oldItem = e.getOldItem();
        if(isDrownedArmor(newItem) && hasDrownedSet(e.getPlayer())){
            canClaim.put(e.getPlayer(), true);
        } else if(isDrownedArmor(oldItem)){
            canClaim.put(e.getPlayer(), false);
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        int cooldownTime = 300;
        block = p.getLocation().getBlock();
        if (block.getType().equals(Material.WATER) && hasDrownedSet(p)) {
            PlayerInventory inv = p.getInventory();
            if (cooldown.containsKey(p)) {
                long timeLeft = ((cooldown.get(p)/1000) + cooldownTime) - System.currentTimeMillis() / 1000;
                if(timeLeft > 0) {
                    p.sendActionBar(Component.text("You still have to wait " + timeLeft + " seconds to use your trident again!").color(TextColor.color(4, 85, 110)));
                }
            } else {
                if (inv.getItemInMainHand().getType().equals(Material.AIR)) {
                    try {

                        if (canClaim.get(p)) {
                            cooldown.put(p, System.currentTimeMillis());
                            ItemStack trident = drownedTrident(AquaticUtils.waterLevel(block));
                            inv.setItemInMainHand(trident);
                            playerStackMap.put(p, trident);
                            canClaim.put(p, false);
                            needsTaking.put(p, true);
                            p.updateInventory();
                            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
                            scheduler.scheduleSyncDelayedTask(plugin, () -> {
                                if (Bukkit.getOnlinePlayers().contains(p)) {
                                    for (int i = 1; i < 28; i++) {
                                        if (inv.getItem(i) != null) {
                                            if (inv.getItem(i).equals(playerStackMap.get(p))) {
                                                inv.setItem(i, new ItemStack(Material.AIR));
                                                canClaim.put(p, true);
                                                needsTaking.put(p, false);
                                                p.updateInventory();
                                            }
                                        }
                                    }
                                }
                            }, 3000);
                        }
                    } catch (NullPointerException exception) {
                        p.sendActionBar(Component.text("If you are seeing this, please take off and put back on a piece of Drowned Armor!").color(TextColor.color(255, 0, 0)));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if (block != null) {
            if (playerStackMap.get(e.getPlayer()) != null && e.getItemDrop().getItemStack().equals(playerStackMap.get(e.getPlayer()))) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        PlayerInventory inv = e.getWhoClicked().getInventory();
        if (inv.getItem(e.getSlot()) != null && block != null) {
            if (e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY) && inv.getItem(e.getSlot()).equals(playerStackMap.get((Player) e.getWhoClicked()))) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        if(needsTaking.get(e.getPlayer())){
            e.getPlayer().getInventory().remove(playerStackMap.get(e.getPlayer()));
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
