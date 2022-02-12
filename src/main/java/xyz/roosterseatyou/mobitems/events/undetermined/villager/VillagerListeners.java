package xyz.roosterseatyou.mobitems.events.undetermined.villager;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import xyz.roosterseatyou.mobitems.utils.ItemUtils;
import xyz.roosterseatyou.mobitems.utils.MathUtils;
import xyz.roosterseatyou.mobitems.utils.mobarmorutils.ListContainers;

import java.util.ArrayList;
import java.util.List;

public class VillagerListeners implements Listener {
    @EventHandler
    public void onTrade(VillagerAcquireTradeEvent e){
        Villager vill = (Villager) e.getEntity();
        if(vill.getVillagerLevel() == 5){
            List<MerchantRecipe> recipes = vill.getRecipes();
            if(MathUtils.rngHelper(3)) {
                MerchantRecipe recipe = ListContainers.genMerchantRecipe();
                ItemStack result = recipe.getResult();
                System.out.println(result.lore());
                ItemUtils.addProfessionFromVill(result, vill);
                System.out.println(result.lore());
                List<MerchantRecipe> newRecipes = new ArrayList<>(recipes);
                newRecipes.add(recipe);
                System.out.println(newRecipes);
                vill.setRecipes(newRecipes);
            }
        }
    }
}
