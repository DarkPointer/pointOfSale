package se.kth.iv1350.sem3pos.controller;


import se.kth.iv1350.sem3pos.integration.*;
import se.kth.iv1350.sem3pos.model.CashRegister;
import se.kth.iv1350.sem3pos.model.PaymentHandler;
import se.kth.iv1350.sem3pos.model.Sale;
import se.kth.iv1350.sem3pos.model.SaleDTO;


/**
 * Manages data and interactions between the view and the model.
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private CashRegister cashRegister;
    private PaymentHandler paymentHandler;
    private Sale currentSale;
    private Printer printer;

    /**
     * Creates a new instance of the {@link Controller} class.
     * @param systemCreator An instance of the external {@link SystemCreator}
     *                     which will provide the controller with access to external systems.
     * @param printer An instance of the external {@link Printer}
     *               which will provide the controller with access to the printer.
     */
    public Controller(SystemCreator systemCreator, Printer printer) {
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.inventorySystem = systemCreator.getInventorySystem();
        this.cashRegister = new CashRegister();
        this.paymentHandler = new PaymentHandler();
        this.printer = printer;
    }

    /**
     * Starts a new sale process.
     */
    public void startSale() {
        this.currentSale = new Sale();
    }

    /**
     * Registers an item in the current sale.
     * @param itemId The identifier of the item to be registered.
     * @param quantity The quantity of the item to be registered
     * @return The registration information including item description, price,
     *               and running total (including VAT).
     */
    public String registerItem(String itemId, int quantity) {
        ItemInfoDTO itemInfo = this.inventorySystem.getItemInfo(itemId);
        String registrationInfo = currentSale.registerItem(itemInfo, quantity);
        return registrationInfo;
    }

    /**
     * Ends the current sale.
     * @return The total price for the current sale including VAT.
     */
    public String endSale() {
        String totalPriceInfo = this.currentSale.endSale();
        return totalPriceInfo;
    }


    /**
     * Passes a payment process to the {@link PaymentHandler} and sends sale information
     *               to external systems.
     * and issues a command to print the receipt.
     * @param amountPaid The amount of cash paid by the customer.
     * @return The amount of change to return to the customer.
     */
    public String makePayment(double amountPaid) {
        double change = this.paymentHandler.handlePayment(this.cashRegister, this.currentSale, amountPaid);
        this.currentSale.updatePaymentDetails(amountPaid, change);
        this.saveSaleLog();
        this.printReceipt();
        String changeAmount = String.format("Change to return to customer: %.2f", change);
        return changeAmount;
    }

    private void saveSaleLog() {
        SaleDTO saleDTO =  this.currentSale.getSaleInfo();
        this.cashRegister.logCompletedSale(this.currentSale);
        this.accountingSystem.saveSaleLog(saleDTO);
        this.inventorySystem.updateInventory(saleDTO);
    }

    private void printReceipt() {
        this.currentSale.printReceipt(this.printer);
    }
}
