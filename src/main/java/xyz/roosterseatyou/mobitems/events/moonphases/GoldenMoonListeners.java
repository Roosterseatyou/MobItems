package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.GoldenMoon;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class GoldenMoonListeners implements Listener {
    private static int stage;
    @EventHandler
    public void onMoonChange(MoonPhaseChangeEvent e) {
        if (e.getPhase() instanceof GoldenMoon) {
            stage = e.getStage();
            if (e.getStage() > 3) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 1));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 12000, 0));
                }
            } else {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 12000, 0));
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (GoldenMoon.isServerActive() && MathUtils.rngHelper(stage*2)) {
            Location pLoc = p.getLocation();
            LivingEntity spawned = (LivingEntity) pLoc.getWorld().spawnEntity(pLoc, ListContainers.getRandEntity());
            spawned.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(60);
            spawned.setHealth(60);
            spawned.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 12000, 2));
            spawned.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 1));
            spawned.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
        }
    }
}
