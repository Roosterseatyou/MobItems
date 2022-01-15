package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;
import org.jetbrains.annotations.NotNull;
import xyz.roosterseatyou.mobitems.moonphases.MoonPhase;

public class MoonPhaseChangeEvent extends WorldEvent implements Cancellable {
    private MoonPhase phase;
    private boolean isCanceled;

    public MoonPhaseChangeEvent(@NotNull World world, MoonPhase phase) {
        super(world);
        this.phase = phase;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
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
}
