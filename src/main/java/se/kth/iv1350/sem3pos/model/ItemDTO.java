package se.kth.iv1350.sem3pos.model;

/**
 * The data transfer object of the {@link Item} class. Instances are immutable.
 */
public final class ItemDTO {
    private String id;
    private String description;
    private float vatRate;
    private double priceExclVAT;
    private double priceInclVAT;
    private int quantity;

    /**
     * Creates a new instance of {@link ItemDTO}.
     * @param itemInfo The {@link Item} to be used to create the DTO.
     */
    ItemDTO(Item itemInfo) {
        this.id = itemInfo.getItemId();
        this.description = itemInfo.getItemDescription();
        this.vatRate = itemInfo.getVatRate();
        this.priceExclVAT = itemInfo.getPriceExclVAT();
        this.priceInclVAT = itemInfo.getPriceInclVAT();
        this.quantity = itemInfo.getQuantity();
    }

    /**
     * Returns the item identifier.
     * @return The item identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the item description.
     * @return The item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the item VAT rate.
     * @return The item VAT rate.
     */
    public float getVatRate() {
        return vatRate;
    }

    /**
     * Returns the item price excluding VAT.
     * @return The item price excluding VAT.
     */
    public double getPriceExclVAT() {
        return priceExclVAT;
    }

    /**
     * Returns the item price including VAT.
     * @return The item price including VAT.
     */
    public double getPriceInclVAT() {
        return priceInclVAT;
    }

    /**
     * Returns the quantity of the item.
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }
}
