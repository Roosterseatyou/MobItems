package xyz.roosterseatyou.mobitems.api.events;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DayNightCycleChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final boolean isDay;
    private final boolean isNight;
    private final World world;

    public DayNightCycleChangeEvent(World world, boolean isDay, boolean isNight) {
        this.world = world;
        this.isDay = isDay;
        this.isNight = isNight;
    }

    public World getWorld() {
        return world;
    }

    public boolean isDay() {
        return isDay;
    }

    public boolean isNight() {
        return isNight;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
