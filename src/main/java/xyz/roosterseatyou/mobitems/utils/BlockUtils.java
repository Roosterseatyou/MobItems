package xyz.roosterseatyou.mobitems.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {
    public static List<Material> getConnected(Block b){
        BlockFace[] bfList = BlockFace.values();
        List<Material> materials = new ArrayList<>();
        for(BlockFace bf : bfList){
            materials.add(b.getRelative(bf).getType());
        }
        return materials;
    }

    public static Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }
}
