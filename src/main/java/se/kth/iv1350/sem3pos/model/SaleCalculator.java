package se.kth.iv1350.sem3pos.model;

import se.kth.iv1350.sem3pos.integration.ItemInfoDTO;

/**
 * The SaleCalculator class is responsible upon the price calculation logic.
 */
public class SaleCalculator {

    /**
     * Creates a new instance of the {@link SaleCalculator}.
     */
    SaleCalculator()
    {

    }

    /**
     * Calculates an item price including VAT.
     * @param item An {@link ItemInfoDTO} containing information about the item.
     * @return The price of the item including VAT.
     */
    public double calcItemPriceInclVAT(ItemInfoDTO item) {
        double vatRate = item.getVatRate();
        double itemPriceExclVAT = item.getPriceExclVAT();
        double itemPriceInclVAT = itemPriceExclVAT + (itemPriceExclVAT * vatRate);
        return itemPriceInclVAT;

    }

    /**
     * Calculates the VAT for the whole sale.
     * @param saleItems An {@link Item} array containing the sale Items.
     * @return The total VAT for the whole sale.
     */
    public double calcWholeSaleVAT(Item[] saleItems) {
        double wholeSaleVAT = 0.0d;
        for (Item item: saleItems) {
            wholeSaleVAT += item.getVatRate() * item.getPriceExclVAT() * item.getQuantity();
        }
        return wholeSaleVAT;

    }

    /**
     * Calculates the total price for the whole sale.
     * @param saleItems An {@link Item} array containing the sale Items.
     * @return The total price for the whole sale including VAT.
     */
    public double calcTotalPriceInclVAT(Item[] saleItems) {
        double totalPriceInclVAT = 0.0d;
        for (Item item: saleItems) {
            totalPriceInclVAT += item.getPriceInclVAT() * item.getQuantity();
        }
        return totalPriceInclVAT;
    }


}
