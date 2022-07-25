package xyz.roosterseatyou.mobitems.api.abilities;

import org.bukkit.event.Event;
import xyz.roosterseatyou.mobitems.EventHelper;
import xyz.roosterseatyou.mobitems.MobItems;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class MobAblility {
    private final ArrayList<EventHelper> eventHelpers = new ArrayList<>();
    private double requiredPlayerLevel;
    private AbilityHandler abilityHandler;

    public abstract void register();

    public abstract void unregister();

    public void registerEventHandlers() {
        eventHelpers.forEach(EventHelper::register);
    }

    public void createListener(Class<? extends Event> clazz, Consumer<Object> consumer) {
        EventHelper eventHelper = new EventHelper(MobItems.getInstance(), clazz, consumer);
    }

    public AbilityHandler getAbilityHandler() {
        return abilityHandler;
    }

    public void setAbilityHandler(AbilityHandler abilityHandler) {
        this.abilityHandler = abilityHandler;
    }

    public double getRequiredPlayerLevel() {
        return requiredPlayerLevel;
    }

    public void setRequiredPlayerLevel(double requiredPlayerLevel) {
        this.requiredPlayerLevel = requiredPlayerLevel;
    }

    public ArrayList<EventHelper> getEventHelpers() {
        return eventHelpers;
    }
}
