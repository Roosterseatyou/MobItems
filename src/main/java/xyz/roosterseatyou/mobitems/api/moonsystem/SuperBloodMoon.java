package xyz.roosterseatyou.mobitems.api.moonsystem;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import xyz.roosterseatyou.mobitems.EventHelper;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.api.events.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.mobgoals.Hostile;

public class SuperBloodMoon extends MoonPhase {
    public static SuperBloodMoon SUPER_BLOOD_MOON = new SuperBloodMoon();

    private SuperBloodMoon() {
        eventHandler(this);
        setCurrentChance(99);
        setMoonStartEventHandler((e) -> {
            if(e.getMoonPhase() == SUPER_BLOOD_MOON && e.getAction() == MoonPhaseChangeEvent.Action.START) {
                Bukkit.broadcast(Component.text("You feel an eerie chill as a Super Blood Moon rises...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
                for(Entity ent : e.getWorld().getEntities()) {
                    if(ent instanceof Mob) {
                        Hostile hostile = new Hostile((Mob) ent, 20, 1.2, 2, 20);
                        Bukkit.getMobGoals().addGoal((Mob) ent, 1, hostile);
                    }
                }
            }
        });

        setMoonStopEventHandler((e) -> {
            if(e.getMoonPhase() == SUPER_BLOOD_MOON && e.getAction() == MoonPhaseChangeEvent.Action.STOP) {
                Bukkit.broadcast(Component.text("You feel the air warm as the Super Blood Moon sets...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
                for(Entity ent : e.getWorld().getEntities()) {
                    if (ent instanceof Mob) {
                        Bukkit.getMobGoals().removeGoal((Mob) ent, Hostile.getStaticKey());
                    }
                }
            }
        });

        EventHelper<EntityAddToWorldEvent> helper = new EventHelper<>(MobItems.getInstance(), EntityAddToWorldEvent.class, (e) -> {
            if(isActive()) {
                if(e.getEntity() instanceof LivingEntity ent) {
                    Hostile hostile = new Hostile((Mob) ent, 20, 1.2, 2, 20);
                    Bukkit.getMobGoals().addGoal((Mob) ent, 1, hostile);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MobItems.getInstance(), () -> {
                        Bukkit.getMobGoals().removeGoal((Mob) ent, hostile);
                    }, 23000 - e.getEntity().getWorld().getTime());
                }
            }
        });
        helper.register();
    }
}
