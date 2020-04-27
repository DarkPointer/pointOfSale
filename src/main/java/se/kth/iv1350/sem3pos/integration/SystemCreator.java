package se.kth.iv1350.sem3pos.integration;

/**
 * Provides access to the external accounting and inventory systems.
 */
public class SystemCreator {

    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * Creates a new instance of the {@link SystemCreator}.
     */
    public SystemCreator() {
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
    }

    /**
     * Provides access to the accounting system.
     * @return An instance of the {@link AccountingSystem}.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Provides access to the inventory system.
     * @return An instance of the {@link InventorySystem}.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
}