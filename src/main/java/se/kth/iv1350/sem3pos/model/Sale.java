package se.kth.iv1350.sem3pos.model;

import se.kth.iv1350.sem3pos.integration.ItemInfoDTO;
import se.kth.iv1350.sem3pos.integration.Printer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The sale class handles the sale logic and stores sale information.
 */
public class Sale {
    private Date saleDate;
    private SaleCalculator saleCalculator;
    private List<Item> saleItems;
    private double totalPriceInclVAT;
    private double wholeSaleVAT;
    private double amountPaid;
    private double change;

    /**
     * Create a new instance of the {@link Sale} class.
     */
    public Sale() {
        this.saleDate = new Date();
        this.saleCalculator = new SaleCalculator();
        this.saleItems = new ArrayList<Item>();
    }

    /**
     * Registers an item in the current sale.
     * @param itemInfo An {@link ItemInfoDTO} containing information about the item.
     * @param quantity The quantity of the item to be registered.
     * @return The registration information including item description, price, and running total (including VAT).
     */
    public String registerItem(ItemInfoDTO itemInfo, int quantity) {
        String newItemId = itemInfo.getId();
        String newItemDescription = itemInfo.getDescription();
        double itemPriceInclVAT = this.saleCalculator.calcItemPriceInclVAT(itemInfo);
        int itemIndex = -1;

        for (int i = 0; i < saleItems.size(); i++) {
            String currentItemId = saleItems.get(i).getId();

            if (currentItemId.equals(newItemId)) {
                itemIndex = i;
            }
        }

        if (itemIndex != -1) {
            this.increaseQuantity(itemIndex, quantity);
        } else {
            Item newItem;

            newItem = new Item(itemInfo, itemPriceInclVAT);
            this.addItem(newItem);
        }

        double runningTotalInclVAT = getTotalPriceInclVAT();
        String result = String.format("ItemDescription: %s, Price: %.2f, RunningTotal(Incl.VAT): %.2f", newItemDescription, itemPriceInclVAT, runningTotalInclVAT);

        return result;
    }

    /**
     * Ends the sale.
     * @return The total price of the sale items including VAT.
     */
    public String endSale() {
        double totalInclVAT = getTotalPriceInclVAT();
        this.wholeSaleVAT = this.saleCalculator.calcWholeSaleVAT(this.saleItems.toArray(new Item[0]));
        String totalPriceInfo = String.format("TotalPrice((incl. VAT)): %.2f", totalInclVAT);

        return totalPriceInfo;
    }

    /**
     * Updates the sale payment details of the current sale.
     * @param amountPaid Amount of cash paid by the customer.
     * @param change Amount of change returned to the customer.
     */
    public void updatePaymentDetails(double amountPaid, double change)
    {
        this.amountPaid= amountPaid;
        this.change = change;
    }

    /**
     * Issues a command to the printer to print out the sale receipt.
     * @param printer An initialized instance of the {@link Printer} class.
     */
    public void printReceipt(Printer printer) {
        ReceiptDTO receiptDTO = this.buildReceipt();
        printer.printReceipt(receiptDTO);
    }

    /**
     * Returns a DTO containing all available information about the current sale.
     * @return A {@link SaleDTO} containing all available information about the current sale.
     */
    public SaleDTO getSaleInfo() {
        ItemDTO[] itemsList = this.buildItemList();
        SaleDTO saleDTO = new SaleDTO(this.saleDate, itemsList, this.totalPriceInclVAT, this.wholeSaleVAT, this.amountPaid, this.change);

        return saleDTO;
    }

    /**
     * Returns the total price of the sale items including VAT.
     * @return The total price of the sale items including VAT.
     */
    public double getTotalPriceInclVAT() {
        this.totalPriceInclVAT = this.saleCalculator.calcTotalPriceInclVAT( this.saleItems.toArray(new Item[0]));
        return this.totalPriceInclVAT;
    }

    private void addItem(Item item) {
        this.saleItems.add(item);
    }

    private void increaseQuantity(int itemIndex, int count) {
        this.saleItems.get(itemIndex).increaseQuantityBy(count);
    }

    private ReceiptDTO buildReceipt() {
        ItemDTO[] itemsList = this.buildItemList();
        ReceiptDTO receipt = new ReceiptDTO(this.saleDate, itemsList, this.totalPriceInclVAT, this.wholeSaleVAT, this.amountPaid, this.change);
        return receipt;
    }

    private ItemDTO[] buildItemList()
    {
        List<ItemDTO> itemList = new ArrayList<ItemDTO>();

        for (Item item: this.saleItems) {
            ItemDTO itemDTO = item.getItemDTO();
            itemList.add(itemDTO);
        }

        return itemList.toArray(new ItemDTO[0]);
    }


}
