package xyz.roosterseatyou.mobitems.moonphases;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.utils.MathUtils;

public class MoonPhase {
    //Stuff not related to the object...
    private static Plugin plugin;
    private int stage;
    private boolean starting;
    private boolean stopping;


    public MoonPhase(Plugin plugin, int stage, boolean stopping){
        MoonPhase.plugin = plugin;
        this.stage = stage;
        this.stopping = stopping;
    }

    public MoonPhase(Plugin plugin, int stage){
        MoonPhase.plugin = plugin;
        this.stage = stage;
        starting = true;
        stopping = false;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }

    public boolean isStopping() {
        return stopping;
    }

    public void setStopping(boolean stopping) {
        this.stopping = stopping;
    }

    public boolean getAction(){
        return isStarting();
    }

    @Override
    public String toString() {
        return "Stage " + stage + " Moon Phase";
    }
}
