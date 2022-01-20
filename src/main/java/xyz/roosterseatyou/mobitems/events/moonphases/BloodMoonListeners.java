package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitChest;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitFeet;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitLegs;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.rabbit.KillerRabbitMask;
import xyz.roosterseatyou.mobitems.moonphases.BloodMoon;
import xyz.roosterseatyou.mobitems.moonphases.MoonPhase;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.PlayerInventoryUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

import java.util.ArrayList;
import java.util.List;

public class BloodMoonListeners implements Listener {
    public static List<EntityType> hostiles = new ArrayList<>();

    public BloodMoonListeners(){
        hostiles.add(EntityType.ZOMBIE);
        hostiles.add(EntityType.SKELETON);
        hostiles.add(EntityType.SPIDER);
        hostiles.add(EntityType.CREEPER);
        hostiles.add(EntityType.HUSK);
        hostiles.add(EntityType.STRAY);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){
        if(BloodMoon.isServerActive() && hostiles.contains(e.getEntityType())){
            LivingEntity entity = (LivingEntity) e.getEntity();
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 0));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 12000, 0));
            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        if(hostiles.contains(entity.getType()) && BloodMoon.isServerActive()){
            if(MathUtils.rngHelper(5)){
                if(e.getEntityType() == EntityType.ZOMBIE){
                    ItemStack item = ListContainers.getRandZombieArmor();
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                } else if(e.getEntityType() == EntityType.SKELETON){
                    /*
                    ItemStack item = ItemUtils.randomItemStackFromList(SkeletonMask.itemsList);
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                     */
                } else if(e.getEntityType() == EntityType.SPIDER){
                    /*
                    ItemStack item = ItemUtils.randomItemStackFromList(SpiderMask.itemsList);
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                     */
                } else if(e.getEntityType() == EntityType.CREEPER){
                    /*
                    ItemStack item = ItemUtils.randomItemStackFromList(CreeperMask.itemsList);
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                     */
                } else if(e.getEntityType() == EntityType.HUSK) {
                    /*
                    ItemStack item = ItemUtils.randomItemStackFromList(HuskMask.itemsList);
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                     */
                } else if (e.getEntityType() == EntityType.STRAY){
                    /*
                    ItemStack item = ItemUtils.randomItemStackFromList(StrayMask.itemsList);
                    entity.getLocation().getWorld().dropItemNaturally(entity.getLocation(), item);
                     */
                }
            }
        }
    }

    @EventHandler
    public void onMoonChange(MoonPhaseChangeEvent e){
        ItemStack[] killerArmor = {KillerRabbitFeet.RABBIT_FEET, KillerRabbitLegs.RABBIT_LEGS,
                KillerRabbitChest.RABBIT_CHEST, KillerRabbitMask.RABBIT_MASK};
        if(e.getPhase() instanceof BloodMoon){
            if(BloodMoon.isServerActive()){
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (PlayerInventoryUtils.hasRabbitSet(p)) {
                        p.getInventory().setArmorContents(killerArmor);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerSleep(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getClickedBlock() != null && ListContainers.bedsList().contains(e.getClickedBlock().getType()) &&
                MoonPhase.isActiveMoonPhase()){
            e.setCancelled(true);
        }
    }
}
