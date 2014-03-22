package org.bukkit.inventory;

import org.bukkit.entity.Merchant;

/**
 * Interface to the inventory of a Merchant
 */
public interface MerchantInventory extends Inventory {

    /**
     * Return the Merchant associated with this Inventory
     *
     * @return The Merchant associated with this Inventory
     */
    public Merchant getMerchant();

}
