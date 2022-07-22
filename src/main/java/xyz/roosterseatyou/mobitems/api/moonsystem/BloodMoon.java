package xyz.roosterseatyou.mobitems.api.moonsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;

public class BloodMoon extends MoonPhase {
    public static BloodMoon BLOOD_MOON = new BloodMoon();

    private BloodMoon() {
        eventHandler(this);
        setCurrentChance(1);
        setMoonStartEventHandler((e) -> {
            if(e.getMoonPhase() == BLOOD_MOON) {
                Bukkit.broadcast(Component.text("You feel an eerie chill as a Blood Moon rises...").color(TextColor.color(64, 4, 4)).decorate(TextDecoration.ITALIC));
                // TODO: add some more start functionality once i get ideas (probably will create some weird stuff, so buckle up :)
            }
        });
        register();
    }
}
