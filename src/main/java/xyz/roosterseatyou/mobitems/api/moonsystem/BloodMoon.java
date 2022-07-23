package xyz.roosterseatyou.mobitems.api.moonsystem;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.EventHelper;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.api.events.MoonPhaseChangeEvent;

public class BloodMoon extends MoonPhase implements Listener {
    public static BloodMoon BLOOD_MOON = new BloodMoon();

    private BloodMoon() {
        MobItems.log.info("Blood Moon is active!");
        eventHandler(this);
        setCurrentChance(1);
        setMoonStartEventHandler((e) -> {
            if(e.getMoonPhase() == BLOOD_MOON && e.getAction() == MoonPhaseChangeEvent.Action.START) {
                Bukkit.broadcast(Component.text("You feel an eerie chill as a Blood Moon rises...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
                for (Entity ent : e.getWorld().getEntities()) {
                    if (ent instanceof Monster mon) {
                        mon.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 1));
                    }
                }
            }
        });

        setMoonStopEventHandler((e) -> {
            if(e.getMoonPhase() == BLOOD_MOON && e.getAction() == MoonPhaseChangeEvent.Action.STOP) {
                Bukkit.broadcast(Component.text("You feel the air warm as the Blood Moon sets...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
            }
        });

        EventHelper<EntityAddToWorldEvent> eventHelper = new EventHelper<>(MobItems.getInstance(), EntityAddToWorldEvent.class, (e) -> {
            if(isActive()) {
                if(e.getEntity() instanceof Monster mon){
                    mon.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
                            (int) ( 24000 - e.getEntity().getWorld().getTime()), 1));
                }
            }
        });
        eventHelper.register();
    }

    public static BloodMoon getBloodMoon() {
        return BLOOD_MOON;
    }
}