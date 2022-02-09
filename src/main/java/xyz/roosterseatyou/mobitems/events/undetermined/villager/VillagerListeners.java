package xyz.roosterseatyou.mobitems.events.undetermined.villager;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import xyz.roosterseatyou.mobitems.itemstacks.undetermined.villager.VillagerChest;

import java.util.ArrayList;
import java.util.List;

public class VillagerListeners implements Listener {
    @EventHandler
    public void onTrade(PlayerTradeEvent e){
        MerchantRecipe recipe = new MerchantRecipe(VillagerChest.VILLAGER_CHEST, 1);
        List<ItemStack> ingredients = new ArrayList<>();
        ingredients.add(new ItemStack(Material.EMERALD, 32));
        ingredients.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        recipe.setIngredients(ingredients);
    }
}
