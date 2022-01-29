package xyz.roosterseatyou.mobitems.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.loot.LootTables;
import xyz.roosterseatyou.mobitems.MobItems;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

public class AllTheTimeListeners implements Listener {
    @EventHandler
    public void onLootPopulate(LootGenerateEvent e) {
        FileConfiguration config = MobItems.getInstance().getConfig();
        if (e.getInventoryHolder() != null) {
            if (e.getLootTable().getKey().equals(LootTables.SIMPLE_DUNGEON.getKey()) && config.getBoolean("loot-spawn-in-dungeons")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.genDungeonArmor());
                }
            } else if (e.getLootTable().getKey().equals(LootTables.ABANDONED_MINESHAFT.getKey()) && config.getBoolean("loot-spawn-in-mineshaft")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.genMineshaft());
                }
            } else if (e.getLootTable().getKey().equals(LootTables.BURIED_TREASURE.getKey()) && config.getBoolean("loot-spawn-in-buried-treasure")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.getRandAquatic());
                }
            } else if (e.getLootTable().getKey().equals(LootTables.SHIPWRECK_TREASURE.getKey()) && config.getBoolean("loot-spawn-in-shipwreck")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.getRandAquatic());
                }
            } else if (e.getLootTable().getKey().equals(LootTables.VILLAGE_WEAPONSMITH.getKey()) && config.getBoolean("loot-spawn-in-villages")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.genVillager());
                }
            } else if (e.getLootTable().key().equals(LootTables.IGLOO_CHEST.getKey()) && config.getBoolean("loot-spawn-in-igloo")) {
                if (MathUtils.rngHelper(2)) {
                    e.getInventoryHolder().getInventory().addItem(ListContainers.genSnow());
                }
            } else if (e.getLootTable().key().equals(LootTables.VILLAGE_TAIGA_HOUSE.key())){
                if(MathUtils.rngHelper(2)){
                    e.getInventoryHolder().getInventory().addItem(ListContainers.genTaiga());
                }
            }
        }
    }
}
