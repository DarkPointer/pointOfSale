package se.kth.iv1350.sem3pos.model;

import se.kth.iv1350.sem3pos.integration.ItemInfoDTO;


/**
 * Item class containing complete information about a specific item added to a sale.
 */
public class Item {
    private String itemId;
    private String itemDescription;
    private float vatRate;
    private double priceExclVAT;
    private double priceInclVAT;
    private int quantity;

    /**
     * Creates a new instance of {@link Item}.
     * @param itemInfo {@link ItemInfoDTO} containing basic information about the item.
     * @param priceInclVAT The calculated price of the item including VAT.
     */
    Item(ItemInfoDTO itemInfo, double priceInclVAT) {
        this.itemId = itemInfo.getItemId();
        this.itemDescription = itemInfo.getItemDescription();
        this.vatRate = itemInfo.getVatRate();
        this.priceExclVAT = itemInfo.getPriceExclVAT();
        this.priceInclVAT = priceInclVAT;
        this.quantity = 1;
    }

    /**
     * Returns the item identifier.
     * @return The item identifier.
     */
    String getItemId() {
        return itemId;
    }

    /**
     * Returns the item description.
     * @return The item description.
     */
    String getItemDescription() {
        return itemDescription;
    }

    /**
     * Returns the item VAT rate.
     * @return The item VAT rate.
     */
    float getVatRate() {
        return vatRate;
    }

    /**
     * Returns the item price excluding VAT.
     * @return The item price excluding VAT.
     */
    double getPriceExclVAT() {
        return priceExclVAT;
    }

    /**
     * Returns the item price including VAT.
     * @return The item price including VAT.
     */
    double getPriceInclVAT() {
        return priceInclVAT;
    }

    /**
     * Returns the quantity of the item.
     * @return The quantity of the item.
     */
    int getQuantity() {
        return quantity;
    }

    /**
     * Returns a DTO of the item.
     * @return The {@link ItemDTO} of the item.
     */
    ItemDTO getItemDTO() {
        ItemDTO itemDTO = new ItemDTO(this);
        return itemDTO;
    }

    /**
     * Increases the registered quantity of the item.
     * @param quantity The amount to increase the quantity with.
     * @return The total quantity of the registered item.
     */
    int increaseQuantityBy(int quantity) {
        this.quantity += quantity;
        return this.quantity;
    }


}
