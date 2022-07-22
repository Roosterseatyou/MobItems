package xyz.roosterseatyou.mobitems.api.moonsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.mobgoals.Hostile;

public class BloodMoon extends MoonPhase {
    public static BloodMoon BLOOD_MOON = new BloodMoon();

    private BloodMoon() {
        eventHandler(this);
        setCurrentChance(1);
        setMoonStartEventHandler((e) -> {
            if(e.getMoonPhase() == BLOOD_MOON) {
                Bukkit.broadcast(Component.text("You feel an eerie chill as a Blood Moon rises...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
            }
        });
        register();
    }
}
