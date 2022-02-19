package xyz.roosterseatyou.mobitems.events.undetermined.villager;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.FarmingUtils;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.VillagerUtils;

import java.util.HashMap;
import java.util.UUID;

public class VillagerProfessionListeners implements Listener {
    private static HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onFarm(BlockBreakEvent e) {
        Block b = e.getBlock();
        Player p = e.getPlayer();
        if (FarmingUtils.isCrop(b) && FarmingUtils.isFullyGrown(b) && VillagerUtils.isFarmer(p)) {
            Material seed = FarmingUtils.getSeeds(b.getType());
            FarmingUtils.replantCrop(b.getLocation(), seed, MobItems.getInstance());
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player p = e.getEntity().getKiller();
            if (VillagerUtils.isLibrarian(p)) {
                int xp = e.getDroppedExp();
                p.sendMessage(String.valueOf(xp));
                e.setDroppedExp(xp * MathUtils.randomIntegerFromRange(1, 5));
                p.sendMessage(String.valueOf(xp * MathUtils.randomIntegerFromRange(1, 5)));
            }
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        int cooldownTime = 30;
        Player p = e.getPlayer();
        if(VillagerUtils.isWeaponsmith(p)) {
            if (cooldown.containsKey(e.getPlayer().getUniqueId())) {
                long timeLeft = ((cooldown.get(p.getUniqueId()) / 1000) + cooldownTime) - System.currentTimeMillis() / 1000;
                if (timeLeft > 0) {
                    p.sendActionBar(Component.text("You still have to wait " + timeLeft + " seconds to use your trident again!").color(TextColor.color(4, 85, 110)));
                }
            } else {
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                for(Player pl : p.getLocation().getNearbyPlayers(5)){
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*20, 1));
                }
            }
        }
    }
}
