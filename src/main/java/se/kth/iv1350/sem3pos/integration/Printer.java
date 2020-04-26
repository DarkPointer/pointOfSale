package se.kth.iv1350.sem3pos.integration;

import se.kth.iv1350.sem3pos.model.ReceiptDTO;

import java.util.Date;

/**
 * Provides access to the printer.
 */
public class Printer {

    /**
     * Creates a new instances of the {@link Printer}.
     */
    public Printer()
    {

    }

    /**
     * Prints out a sale receipt.
     * @param receipt A {@link ReceiptDTO} containing information about a sale.
     */
    public void printReceipt(ReceiptDTO receipt)
    {
        System.out.println(receipt.getReceipt());
    }

}
