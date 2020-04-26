package se.kth.iv1350.sem3pos.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The receipt data transfer object which holds essential information about the sale. Instances are immutable.
 */
public final class ReceiptDTO {

    private Date saleDate;
    private String storeName;
    private String storeAddress;
    private ItemDTO[] saleItems;
    private double totalPrice;
    private double totalVAT;
    private double amountPaid;
    private double change;
    private String receipt;

    /**
     * Creates a new instance of the {@link ReceiptDTO} class.
     * @param saleDate The sale start date.
     * @param saleItems An {@link ItemDTO} array containing the sale items.
     * @param totalPrice The total price of the sale.
     * @param totalVAT The total VAT of the sale.
     * @param amountPaid The amount paid by the customer.
     * @param change The amount of change returned to the customer.
     */
    ReceiptDTO(Date saleDate, ItemDTO[] saleItems, double totalPrice, double totalVAT, double amountPaid, double change)
    {
        this.storeName= "Humble Store";
        this.storeAddress = "Humble street 10, Humble City, Humble";
        this.saleDate = saleDate;
        this.saleItems = saleItems;
        this.totalPrice = totalPrice;
        this.totalVAT= totalVAT;
        this.amountPaid = amountPaid;
        this.change = change;

        StringBuilder receiptData = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lineSeparator = System.lineSeparator();

        receiptData.append("------------------------ReceiptStart------------------------");
        receiptData.append(lineSeparator);

        receiptData.append(dateFormat.format(this.saleDate));
        receiptData.append(lineSeparator);
        receiptData.append(this.storeName);
        receiptData.append(lineSeparator);
        receiptData.append(this.storeAddress);
        receiptData.append(lineSeparator);
        receiptData.append(lineSeparator);

        receiptData.append("Purchased products:");
        receiptData.append(lineSeparator);

        for (ItemDTO saleItem: this.saleItems) {
            String receiptItemInfo = String.format("%s x %d, %.2f", saleItem.getDescription(), saleItem.getQuantity(), saleItem.getPriceInclVAT());
            receiptData.append(receiptItemInfo);
            receiptData.append(lineSeparator);
        }
        receiptData.append(lineSeparator);

        String receiptTotalPrice = String.format("Total Price (incl. VAT): %.2f", this.totalPrice);
        receiptData.append(receiptTotalPrice);
        receiptData.append(lineSeparator);

        String receiptWholeSaleVAT = String.format("Total VAT: %.2f", this.totalVAT);
        receiptData.append(receiptWholeSaleVAT);
        receiptData.append(lineSeparator);

        String receiptPayment = String.format("Amount paid: %.2f, change: %.2f", this.amountPaid, this.change);
        receiptData.append(receiptPayment);
        receiptData.append(lineSeparator);

        receiptData.append("------------------------ReceiptEnd------------------------");

        this.receipt = receiptData.toString();

    }

    /**
     * Returns the sale start date.
     * @return The sale start date.
     */
    public Date getSaleDate() {
        return saleDate;
    }

    /**
     * Returns the store name.
     * @return The store name.
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Returns the store address.
     * @return The store address.
     */
    public String getStoreAddress() {
        return storeAddress;
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
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double getTotalVAT() {
        return totalVAT;
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

    /**
     * Returns a printer-friendly formatted receipt.
     * @return A <code>String</code> containing formatted receipt.
     */
    public String getReceipt()
    {
        return this.receipt;
    }
}
