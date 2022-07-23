package xyz.roosterseatyou.mobitems.api.events;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.api.moonsystem.MoonPhase;

public class MoonPhaseChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private MoonPhase moonPhase;
    private final World world;
    private Action action;

    public enum Action {
        START,
        STOP
    }

    public MoonPhaseChangeEvent(MoonPhase moonPhase, Action action, World world) {
        this.moonPhase = moonPhase;
        this.action = action;
        this.world = world;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public MoonPhase getMoonPhase() {
        return moonPhase;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setMoonPhase(MoonPhase moonPhase) {
        this.moonPhase = moonPhase;
    }

    public World getWorld() {
        return world;
    }
}
