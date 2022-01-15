package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.itemstacks.undead.zombie.ZombieMask;
import xyz.roosterseatyou.mobitems.moonphases.BloodMoon;
import xyz.roosterseatyou.mobitems.moonphases.MoonPhase;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class BloodMoonListeners implements Listener {
    private Plugin plugin;
    public static List<EntityType> hostiles = new ArrayList<>();

    public BloodMoonListeners(Plugin plugin){
        this.plugin = plugin;
        hostiles.add(EntityType.ZOMBIE);
        hostiles.add(EntityType.SKELETON);
        hostiles.add(EntityType.SPIDER);
        hostiles.add(EntityType.CREEPER);
        hostiles.add(EntityType.HUSK);
        hostiles.add(EntityType.STRAY);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){
        long time = e.getEntity().getWorld().getTime();
        if(BloodMoon.isActive() && hostiles.contains(e.getEntityType())){
            LivingEntity entity = (LivingEntity) e.getEntity();
            entity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 0));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 12000, 0));
            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        if(hostiles.contains(entity.getType()) && BloodMoon.isActive()){
            if(MathUtils.rngHelper(3)){
                if(e.getEntityType() == EntityType.ZOMBIE){
                    ItemStack item = ItemUtils.randomItemStackFromList(ZombieMask.itemsList);
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
}
