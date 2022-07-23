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
    private static final GoalKey<Mob> key = GoalKey.of(Mob.class, new NamespacedKey(MobItems.getInstance(), "hostility"));
    private final Mob entity;
    private final double range;
    private final double speed;
    private final double attackRange;
    private final double attackInterval;
    private int cooldown;
    private Player target;

    public Hostile(@NotNull Mob entity, double range, double speed, double attackRange, double attackInterval) {
        this.entity = entity;
        this.range = range;
        this.speed = speed;
        this.attackRange = attackRange;
        this.attackInterval = attackInterval;
    }

    @Override
    public void tick() {
        if (target == null){
            locatePlayer();
            return;
        }
        if (entity.getLocation().distance(target.getLocation()) > range) {
            entity.setTarget(null);
            target = null;
            return;
        }

        if (entity.getLocation().distance(target.getLocation()) < range) {
            entity.getPathfinder().moveTo(target.getLocation(), speed);
        }
        if (entity.getLocation().distance(target.getLocation()) < attackRange) {
            if (cooldown <= 0) {
                target.damage(2);
                cooldown = (int) attackInterval;
                if (target.isDead() || target.getHealth() <= 0) {
                    entity.setTarget(null);
                    target = null;
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
                target = player;
                return;
            }
        }
    }

    @Override
    public boolean shouldActivate() {
        MobItems.log.info("[" + entity.getType().name() + "] Hostile shouldActivate");
        if (target == null || target.isDead()) {
            locatePlayer();
            return false;
        }
        return !(entity.getLocation().distance(target.getLocation()) > range);
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

    public static GoalKey<Mob> getStaticKey() {
        return key;
    }
}
