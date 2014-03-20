package org.bukkit.inventory;

import org.apache.commons.lang.Validate;

import org.bukkit.Utility;

/**
 * Represents some type of trade offer.
 */
public class MerchantTrade implements Cloneable {

    private ItemStack buyingItem1;
    private ItemStack buyingItem2;
    private ItemStack sellingItem;
    private int uses = 0;
    protected int maxUses;
    protected TradeType type = TradeType.PLUGIN_ADDED;

    @Utility
    protected MerchantTrade() {}

    public MerchantTrade(ItemStack buyingitem1, ItemStack buyingItem2, ItemStack sellingItem) {
        this(buyingitem1, buyingItem2, sellingItem, 7);
    }

    public MerchantTrade(ItemStack a, ItemStack b, ItemStack c, int maxUses) {
        Validate.notNull(a, "Cannot have a null buying item!");
        Validate.notNull(c, "Cannot have a null selling item!");
        this.buyingItem1 = a.clone();
        this.buyingItem2 = b.clone();
        this.sellingItem = c.clone();
        this.maxUses = maxUses;
    }

    public ItemStack getFirstBuyingItem() {
        return buyingItem1.clone();
    }

    protected void setFirstBuyingItem(ItemStack item) {
        this.buyingItem1 = item.clone();
    }

    public ItemStack getSeconBuyingItem() {
        return buyingItem2.clone();
    }

    protected void setSecondBuyingItem(ItemStack item) {
        this.buyingItem1 = item.clone();
    }


    public boolean hasSecondBuyingItem() {
        return buyingItem2 != null;
    }

    public ItemStack getResult() {
        return sellingItem.clone();
    }

    protected void setResult(ItemStack item) {
        this.buyingItem1 = item.clone();
    }

    public int useTradeRecipe() {
        return ++uses;
    }

    public int getUses() {
        return uses;
    }

    public int increaseMaxUses(int maxUsesToIncrease) {
        maxUses += maxUsesToIncrease;
        return maxUses;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public int setMaxUses(int newMax) {
        if (newMax > 0) {
            return maxUses;
        }
        this.maxUses = newMax;
        return maxUses;
    }

    public boolean isTradeExpired() {
        return uses >= maxUses;
    }

    public TradeType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MerchantTrade))
            return false;
        else {
            MerchantTrade recipe = (MerchantTrade) o;
            return this.buyingItem1.equals(recipe.buyingItem1) && this.sellingItem.equals(recipe.sellingItem) &&
                    ((this.buyingItem2 == null && recipe.buyingItem2 == null) ||
                            (this.buyingItem2 != null && recipe.buyingItem2 != null &&
                                    this.buyingItem2.equals(recipe.buyingItem2)));
        }
    }

    @Override
    public MerchantTrade clone() {
        try {
            MerchantTrade trade = (MerchantTrade) super.clone();

            if (this.buyingItem1 != null) {
                trade.buyingItem1 = this.buyingItem1.clone();
            }
            if (this.buyingItem2 != null) {
                trade.buyingItem2 = this.buyingItem2.clone();
            }
            if (this.sellingItem != null) {
                trade.sellingItem = this.sellingItem.clone();
            }
            return trade;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    public enum TradeType {
        VANILLA,
        PLUGIN_ADDED
    }

}
