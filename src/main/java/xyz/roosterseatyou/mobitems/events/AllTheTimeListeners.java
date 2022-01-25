package xyz.roosterseatyou.mobitems.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.loot.LootTables;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class AllTheTimeListeners implements Listener {
    @EventHandler
    public void onLootPopulate(LootGenerateEvent e) {
        if (e.getLootTable().getKey().equals(LootTables.SIMPLE_DUNGEON.getKey())) {
            if (MathUtils.rngHelper(2)) {
                e.getInventoryHolder().getInventory().addItem(ListContainers.genDungeonArmor());
            }
        } else if (e.getLootTable().getKey().equals(LootTables.ABANDONED_MINESHAFT.getKey())) {
            if (MathUtils.rngHelper(2)) {
                e.getInventoryHolder().getInventory().addItem(ListContainers.genMineshaft());
            }
        } else if (e.getLootTable().getKey().equals(LootTables.BURIED_TREASURE.getKey())) {
            if (MathUtils.rngHelper(2)) {
                e.getInventoryHolder().getInventory().addItem(ListContainers.getRandAquatic());
            }
        } else if (e.getLootTable().getKey().equals(LootTables.SHIPWRECK_TREASURE.getKey())) {
            if (MathUtils.rngHelper(2)) {
                e.getInventoryHolder().getInventory().addItem(ListContainers.getRandAquatic());
            }
        } else if (e.getLootTable().getKey().equals(LootTables.VILLAGE_WEAPONSMITH.getKey())) {
            if (MathUtils.rngHelper(2)) {
                e.getInventoryHolder().getInventory().addItem(ListContainers.genVillager());
            }
        }
    }
}
