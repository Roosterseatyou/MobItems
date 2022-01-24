package xyz.roosterseatyou.mobitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.loot.LootTables;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class AllTheTimeListeners implements Listener {
    @EventHandler
    public void onLootPopulate(LootGenerateEvent e){
        if(e.getLootTable().equals(LootTables.SIMPLE_DUNGEON)){
            if(MathUtils.rngHelper(2)){
                e.getLoot().add(ListContainers.genDungeonArmor());
            }
        }else if(e.getLootTable().equals(LootTables.ABANDONED_MINESHAFT)){
            if(MathUtils.rngHelper(2)){
                e.getLoot().add(ListContainers.genMineshaft());
            }
        } else if(e.getLootTable().equals(LootTables.BURIED_TREASURE)){
            if(MathUtils.rngHelper(2)){
                e.getLoot().add(ListContainers.getRandAquatic());
            }
        } else if(e.getLootTable().equals(LootTables.SHIPWRECK_TREASURE)){
            if(MathUtils.rngHelper(2)){
                e.getLoot().add(ListContainers.getRandAquatic());
            }
        } else if(e.getLootTable().equals(LootTables.VILLAGE_WEAPONSMITH)){
            if(MathUtils.rngHelper(2)){
                e.getLoot().add(ListContainers.genVillager());
            }
        }
    }
}
