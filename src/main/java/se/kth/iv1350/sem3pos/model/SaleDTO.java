package se.kth.iv1350.sem3pos.model;

import java.util.Date;

/**
 * The data transfer object of the {@link Sale} class. Instances are immutable.
 */
public final class SaleDTO {
    private Date saleDate;
    private ItemDTO[] saleItems;
    private double totalPriceInclVAT;
    private double wholeSaleVAT;
    private double amountPaid;
    private double change;

    /**
     * Creates a new instance.
     * @param saleDate The sale start date.
     * @param saleItems An {@link ItemDTO} array containing the sale items.
     * @param totalPriceInclVAT The total price of the sale including VAT.
     * @param wholeSaleVAT The total VAT for the whole sale.
     * @param amountPaid The amount of cash paid by the customer.
     * @param change The amount of change returned to the customer.
     */
    SaleDTO(Date saleDate, ItemDTO[] saleItems, double totalPriceInclVAT, double wholeSaleVAT, double amountPaid, double change) {
        this.saleDate= saleDate;
        this.totalPriceInclVAT = totalPriceInclVAT;
        this.wholeSaleVAT = wholeSaleVAT;
        this.saleItems = saleItems;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    /**
     * Returns the sale start date.
     * @return The sale start date.
     */
    public Date getSaleDate() {
        return saleDate;
    }

    /**
     * Returns the sale items.
     * @return An {@link ItemDTO} array containing the sale items.
     */
    public ItemDTO[] getSaleItems() {
        return saleItems;
    }

    /**
     * Returns the total price of the sale including VAT.
     * @return The total price of the sale including VAT.
     */
    public double getTotalPriceInclVAT() {
        return totalPriceInclVAT;
    }

    /**
     * Returns the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double getWholeSaleVAT() {
        return wholeSaleVAT;
    }

    /**
     * Returns the amount of cash paid by the customer.
     * @return The amount of cash paid by the customer.
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Returns the amount of change.
     * @return The amount of change.
     */
    public double getChange() {
        return change;
    }
}
