package xyz.roosterseatyou.mobitems.events.custom;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HandshakeCompletedEvent;

public class PlayerObtainItemEvent extends PlayerEvent {
    private ItemStack item;
    private Reason reason;
    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    enum Reason{
        PICK_UP,
        FROM_INVENTORY
    }

    public PlayerObtainItemEvent(@NotNull Player player, ItemStack item, Reason reason) {
        super(player);
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
