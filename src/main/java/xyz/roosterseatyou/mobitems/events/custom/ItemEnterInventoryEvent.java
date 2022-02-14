package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemEnterInventoryEvent extends InventoryEvent {
    private ItemStack item;
    private Reason reason;

    enum Reason{
        PICK_UP,
        FROM_INVENTORY
    }

    public ItemEnterInventoryEvent(@NotNull InventoryView transaction, ItemStack item, Reason reason) {
        super(transaction);
        this.item = item;
        this.reason = reason;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
}
