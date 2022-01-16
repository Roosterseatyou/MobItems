package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.moonphases.MoonPhase;

public class MoonPhaseChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private MoonPhase phase;
    private boolean isCanceled;

    public MoonPhaseChangeEvent(MoonPhase phase) {
        this.phase = phase;

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

    public int getStage(){
        return phase.getStage();
    }

    @Override
    public String toString() {
        return "MoonPhase " + phase + "was set to " + phase.getAction();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
