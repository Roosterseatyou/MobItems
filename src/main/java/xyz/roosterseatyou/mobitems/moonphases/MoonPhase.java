package xyz.roosterseatyou.mobitems.moonphases;

public class MoonPhase {
    //Stuff not related to the object...
    private static boolean activeMoonPhase = false;
    private int stage;
    private boolean starting;
    private boolean stopping;


    public MoonPhase(int stage, boolean stopping){
        this.stage = stage;
        this.stopping = stopping;
    }

    public MoonPhase(int stage){
        this.stage = stage;
        starting = true;
        stopping = false;
    }

    public static boolean isActiveMoonPhase() {
        return activeMoonPhase;
    }

    public static void setActiveMoonPhase(boolean activeMoonPhase) {
        MoonPhase.activeMoonPhase = activeMoonPhase;
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
