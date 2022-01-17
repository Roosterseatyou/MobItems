package xyz.roosterseatyou.mobitems.events.moonphases;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.roosterseatyou.mobitems.events.custom.MoonPhaseChangeEvent;
import xyz.roosterseatyou.mobitems.moonphases.BlueMoon;

public class BlueMoonListeners implements Listener {
    @EventHandler
    public void onMoonChange(MoonPhaseChangeEvent e){
        if(e.getPhase() instanceof BlueMoon){
            BlueMoon moon = (BlueMoon) e.getPhase();
            int stage = moon.getStage();
            if(stage <= 2){
                for(Player p: Bukkit.getOnlinePlayers()){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 12000, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 12000, 1));
                }
            }else if(stage <= 3){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 12000, 1));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 12000, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 0));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 12000, 0));
                }
            }
        }
    }
}
