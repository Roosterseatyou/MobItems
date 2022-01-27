package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.moonphases.MoonPhase;

public class MoonPhaseChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private MoonPhase phase;
    private boolean isCanceled;
    private Activator activator;
    public enum Activator{
        COMMAND,
        ITEM,
        TIME
    }

    public MoonPhaseChangeEvent(MoonPhase phase, Activator activator) {
        this.phase = phase;
        this.activator = activator;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public MoonPhase getPhase() {
        return phase;
    }

    public void setPhase(MoonPhase phase) {
        this.phase = phase;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {
        phase.setStopping(true);
    }

    @Override
    public String toString() {
        return phase + " was set to " + phase.getAction();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
