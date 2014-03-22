package org.bukkit.event.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Merchant;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantTrade;

/**
 * This event is called whenever a Player is interacting with a
 * MerchantInventory
 */
public class MerchantTradeEvent extends InventoryEvent {

    private static final HandlerList handlers = new HandlerList();
    private Merchant merchant;
    private MerchantTrade tradeOffer;

    public MerchantTradeEvent(Merchant merchant, MerchantTrade tradeOffer, InventoryView transaction) {
        super(transaction);
        this.merchant = merchant;
        this.tradeOffer = tradeOffer;
    }

    /**
     * Returns the merchant involved in this event.
     *
     * @return Merchant that is involved in this event.
     */
    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * Returns the player involved in this event.
     *
     * @return Player who is involved in this event.
     */
    public final HumanEntity getPlayer() {
        return transaction.getPlayer();
    }

    /**
     * Returns the trade that has been found. If the event was triggered and
     * the Merchant did not have a recipe matching the current items in the
     * inventory, the trade will be null.
     *
     * @return The trade found.
     */
    public final MerchantTrade getTradeOffer() {
        return tradeOffer;
    }

    /**
     * Replace the found MerchantTrade offer. The Merchant will acknowledge this
     * new offer only this once, but will not permanently add this offer to
     * it's list of available offers.
     *
     * @param merchantTrade The replacing offer.
     */
    public void setTradeOffer(MerchantTrade merchantTrade) {
        tradeOffer = merchantTrade;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
