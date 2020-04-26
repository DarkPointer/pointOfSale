package se.kth.iv1350.sem3pos.model;

/**
 * Processes sale payments.
 */
public class PaymentHandler {
    /**
     * Creates a new instance of the {@link PaymentHandler}.
     */
    public PaymentHandler() {
    }

    /**
     * Handles a payment and increases the balance available in the cash register.
     * @param cashRegister An initialized instance of the {@link CashRegister}.
     * @param saleInfo The sale which the payment is intended for.
     * @param amountPaid The amount of cash paid.
     * @return The amount of change.
     */
    public double handlePayment(CashRegister cashRegister, Sale saleInfo, double amountPaid) {
        double totalPriceInclVAT = saleInfo.getTotalPriceInclVAT();
        double change = amountPaid - totalPriceInclVAT;
        cashRegister.increaseBalance(totalPriceInclVAT);
        return change;
    }


}