package xyz.roosterseatyou.mobitems.api.abilities;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class AbilityHandler {
    private ArrayList<MobAblility> abilities = new ArrayList<>();
    private ItemStack item;
    private EntityType entityType;

    public AbilityHandler(ItemStack item, EntityType entityType) {
        this.item = item;
        this.entityType = entityType;
    }

    public void register() {
        abilities.forEach(MobAblility::register);
    }

    public void unregister() {
        abilities.forEach(MobAblility::unregister);
    }

    public void addAbility(MobAblility ability) {
        abilities.add(ability);
    }

    public void removeAbility(MobAblility ability) {
        abilities.remove(ability);
    }

    public ItemStack getItem() {
        return item;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public ArrayList<MobAblility> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<MobAblility> abilities) {
        this.abilities = abilities;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
