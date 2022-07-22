package xyz.roosterseatyou.mobitems.mobgoals;

import com.destroystokyo.paper.entity.ai.Goal;
import com.destroystokyo.paper.entity.ai.GoalKey;
import com.destroystokyo.paper.entity.ai.GoalType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.MobItems;

import java.util.EnumSet;

public class Hostile implements Goal<Mob> {
    private final GoalKey<Mob> key;
    private final Mob entity;
    private final double range;
    private final double speed;
    private final double attackRange;
    private final double attackInterval;
    private int cooldown;

    public Hostile(@NotNull Mob entity, double range, double speed, double attackRange, double attackInterval) {
        this.key = GoalKey.of(Mob.class, new NamespacedKey(MobItems.getInstance(), "hostility"));
        this.entity = entity;
        this.range = range;
        this.speed = speed;
        this.attackRange = attackRange;
        this.attackInterval = attackInterval;
    }

    @Override
    public void tick() {
        locatePlayer();
        if (entity.getTarget() == null) return;
        if (entity.getLocation().distance(entity.getTarget().getLocation()) > range) {
            entity.setTarget(null);
            return;
        }

        if (entity.getLocation().distance(entity.getTarget().getLocation()) < range) {
            entity.getPathfinder().moveTo(entity.getTarget().getLocation(), speed);
        }
        if (entity.getLocation().distance(entity.getTarget().getLocation()) < attackRange) {
            if (cooldown <= 0) {
                entity.getTarget().damage(2);
                cooldown = (int) attackInterval;
                if (entity.getTarget().isDead() || entity.getTarget().getHealth() <= 0) {
                    entity.setTarget(null);
                    Bukkit.getServer().broadcast(Component.text("<The Blood God> Blood for the one and only Blood God.").color(TextColor.color(66, 3, 6)));
                    entity.getWorld().playSound(entity.getLocation(), "entity.lightning_bolt.thunder", 1000, 1);
                }
            } else {
                cooldown--;
            }
        }
    }

    public void locatePlayer() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getLocation().distance(entity.getLocation()) < range) {
                if(player.isDead() || player.getHealth() <= 0) continue;
                entity.setTarget(player);
            }
        }
    }

    @Override
    public boolean shouldActivate() {
        if (entity.getTarget() == null || entity.getTarget().isDead()) {
            return false;
        }
        return !(entity.getLocation().distance(entity.getTarget().getLocation()) > range);
    }

    @Override
    public @NotNull GoalKey<Mob> getKey() {
        return key;
    }

    @Override
    public @NotNull EnumSet<GoalType> getTypes() {
        return EnumSet.of(GoalType.UNKNOWN_BEHAVIOR);
    }

    @Override
    public boolean shouldStayActive() {
        return shouldActivate();
    }
}
