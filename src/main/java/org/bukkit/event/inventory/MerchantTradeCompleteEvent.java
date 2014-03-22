package org.bukkit.event.inventory;

import org.bukkit.entity.Merchant;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantTrade;

/**
 * This event is called whenever a Player is completing a MerchantTrade with a
 * Merchant. The resulting item of this event is what is picked up by the
 * player.
 */
public class MerchantTradeCompleteEvent extends MerchantTradeEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private ItemStack resultingItem;

    public MerchantTradeCompleteEvent(Merchant merchant, MerchantTrade tradeOffer, ItemStack result, InventoryView transaction) {
        super(merchant, tradeOffer, transaction);
        cancelled = false;
        resultingItem = result.clone();
    }

    /**
     * Return the resulting item reward for the MerchantTrade made to the
     * Merchant by the player.
     *
     * @return The ItemStack that resulted form the MerchantTrade
     */
    public ItemStack getResult() {
        return resultingItem.clone();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
