package se.kth.iv1350.sem3pos.integration;

/**
 * Item information data transfer object that holds information about the item identifier,
 *              description, price excluding VAT and the vat rate. Instances are immutable.
 */
public final class ItemInfoDTO {
    private String itemId;
    private String itemDescription;
    private double priceExclVAT;
    private float vatRate;

    /**
     * Creates a new instance of the item information data transfer object.
     * @param itemId The item identifier.
     * @param itemDescription The item description.
     * @param priceExclVAT The item prices excluding VAT.
     * @param vatRate The VAT rate of the item.
     */
    ItemInfoDTO(String itemId, String itemDescription, double priceExclVAT, float vatRate) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.priceExclVAT = priceExclVAT;
        this.vatRate = vatRate;
    }

    /**
     * Returns the item identifier.
     * @return A <code>String</code> containing the item identifier.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Returns the item description.
     * @return A <code>String</code> containing the item description.
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Returns the item price excluding VAT.
     * @return A <code>double</code> containing the item price excluding VAT.
     */
    public double getPriceExclVAT() {
        return priceExclVAT;
    }

    /**
     * Returns the VAT rate of the item.
     * @return A <code>float</code> containing the VAT rate of the item.
     */
    public float getVatRate() {
        return vatRate;
    }

    /**
     * Checks whether the attributes of an instance of the class {@link ItemInfoDTO} contains the same values as the current instance or not.
     * @param obj The object to compare with the current instance of {@link ItemInfoDTO}.
     * @return A <code>boolean</code> indicating whether the <code>obj</code> attributes hold the same values as the current instance's attributes.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result;
        if((obj == null) || !(obj instanceof ItemInfoDTO)){
            result = false;
        } else {
            ItemInfoDTO otherItem = (ItemInfoDTO)obj;
            String itemId = otherItem.getItemId();
            String itemDescription = otherItem.getItemDescription();
            double itemPriceExclVAT = otherItem.getPriceExclVAT();
            float itemVatRate = otherItem.getVatRate();

            if (this.itemId.equals(itemId) && this.itemDescription.equals(itemDescription)
                    && this.priceExclVAT == itemPriceExclVAT && this.vatRate == itemVatRate) {

                result = true;
            } else {
                result =  false;
            }
        }
        return result;
    }

}
