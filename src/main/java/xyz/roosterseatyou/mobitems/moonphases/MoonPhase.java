package xyz.roosterseatyou.mobitems.moonphases;

public class MoonPhase {
    private static boolean activeMoonPhase = false;
    private boolean starting;
    private boolean stopping;


    public MoonPhase(boolean stopping){
        this.stopping = stopping;
    }

    public MoonPhase(){
        starting = true;
        stopping = false;
    }

    public static boolean isActiveMoonPhase() {
        return activeMoonPhase;
    }

    public static void setActiveMoonPhase(boolean activeMoonPhase) {
        MoonPhase.activeMoonPhase = activeMoonPhase;
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
}
