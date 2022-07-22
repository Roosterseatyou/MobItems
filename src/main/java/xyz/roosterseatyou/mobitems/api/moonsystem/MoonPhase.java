package xyz.roosterseatyou.mobitems.api.moonsystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import xyz.roosterseatyou.mobitems.EventHelper;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.api.events.DayNightCycleChangeEvent;
import xyz.roosterseatyou.mobitems.api.events.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class MoonPhase {
    private static final Plugin plugin = MobItems.getInstance();
    private int currentChance;

    private Consumer<MoonPhaseChangeEvent> moonStartEventHandler;

    private final ArrayList<EventHelper> eventHelpers = new ArrayList<>();
    private boolean isActive;

    public void register() {
        eventHelpers.forEach(EventHelper::register);
    }

    public void setCurrentChance(int currentChance) {
        this.currentChance = currentChance;
    }

    public int getCurrentChance() {
        return currentChance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setMoonStartEventHandler(Consumer<MoonPhaseChangeEvent> moonStartEventHandler) {
        this.moonStartEventHandler = moonStartEventHandler;
        eventHelpers.add(new EventHelper<>(plugin, MoonPhaseChangeEvent.class, moonStartEventHandler));
    }

    public void eventHandler(MoonPhase moonPhase) {
        Consumer<DayNightCycleChangeEvent> handler = (e) -> {
            if(e.isNight()) {
                if(MathUtils.doubleRngHelper(getCurrentChance())) {
                    MoonPhaseChangeEvent event = new MoonPhaseChangeEvent(moonPhase, MoonPhaseChangeEvent.Action.START);
                    Bukkit.getPluginManager().callEvent(event);
                    moonPhase.setActive(true);
                    moonPhase.setCurrentChance(0);
                } else {
                    moonPhase.setCurrentChance(currentChance + 1);
                }
            }

            if(e.isDay()) {
                if(moonPhase.isActive()) {
                    MoonPhaseChangeEvent event = new MoonPhaseChangeEvent(moonPhase, MoonPhaseChangeEvent.Action.STOP);
                    Bukkit.getPluginManager().callEvent(event);
                    moonPhase.setActive(false);
                }
            }
        };
        eventHelpers.add(new EventHelper<>(plugin, DayNightCycleChangeEvent.class, handler));
    }
}
