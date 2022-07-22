package xyz.roosterseatyou.mobitems.api.moonsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BloodMoon extends MoonPhase implements Listener {
    public static BloodMoon BLOOD_MOON = new BloodMoon();

    private BloodMoon() {
        eventHandler(this);
        setCurrentChance(1);
        setMoonStartEventHandler((e) -> {
            if(e.getMoonPhase() == BLOOD_MOON) {
                Bukkit.broadcast(Component.text("You feel an eerie chill as a Blood Moon rises...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
            }
            for(Entity ent : e.getWorld().getEntities()) {
                if(ent instanceof Monster mon) {
                    mon.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 1));
                }
            }
        });
        register();
    }
}
