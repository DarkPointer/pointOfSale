package se.kth.iv1350.sem3pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sem3pos.integration.InventorySystem;
import se.kth.iv1350.sem3pos.integration.ItemInfoDTO;
import se.kth.iv1350.sem3pos.integration.SystemCreator;
import java.util.Date;



class SaleTest {

    private Sale firstSaleInstance;
    private Sale secondSaleInstance;
    SystemCreator systemCreator;
    InventorySystem inventorySystem;

    @BeforeEach
    void setUp() throws InterruptedException {
        firstSaleInstance = new Sale();
        Thread.sleep(25);
        secondSaleInstance = new Sale();
        systemCreator = new SystemCreator();
        inventorySystem = systemCreator.getInventorySystem();
    }

    @AfterEach
    void tearDown() {
        firstSaleInstance = null;
        secondSaleInstance = null;
        systemCreator = null;
        inventorySystem = null;
    }

    @Test
    void testItemRegistration() {
        ItemInfoDTO testItem = inventorySystem.getItemInfo("item1");
        firstSaleInstance.registerItem(testItem,1);
        ItemDTO[] registeredItems = firstSaleInstance.getSaleInfo().getSaleItems();
        String testItemId = testItem.getId();
        String testItemDescription = testItem.getDescription();
        String registeredItemId = registeredItems[0].getId();
        String registeredItemDescription = registeredItems[0].getDescription();
        boolean result = testItemDescription.equals(registeredItemDescription) && testItemId.equals(registeredItemId);
        assertTrue(result, "The registered item does not match the item that was intended to be registered.");
    }

    @Test
    void testGetTotalPriceInclVAT() {
        ItemInfoDTO testItem = inventorySystem.getItemInfo("item1");
        ItemInfoDTO secondTestItem = inventorySystem.getItemInfo("item2");
        firstSaleInstance.registerItem(testItem,1);
        secondSaleInstance.registerItem(secondTestItem,1);
        double totalPriceFirstSale = firstSaleInstance.getTotalPriceInclVAT();
        double totalPriceSecondSale = secondSaleInstance.getTotalPriceInclVAT();
        assertNotEquals(totalPriceFirstSale, totalPriceSecondSale, "Two sale instances with two different items having different prices yielded the same total price.");
    }

    @Test
    void testAmountPaid() {
        firstSaleInstance.updatePaymentDetails(10.12, 0.0);
        secondSaleInstance.updatePaymentDetails(22.4,1.0);
        double amountPaidFirstInstance = firstSaleInstance.getSaleInfo().getAmountPaid();
        double amountPaidSecondInstance = secondSaleInstance.getSaleInfo().getAmountPaid();
        assertNotEquals(amountPaidFirstInstance, amountPaidSecondInstance, "Different amount of cash paid in two different sales resulted in same amount paid.");
    }

    @Test
    void testChange() {
        firstSaleInstance.updatePaymentDetails(10.0, 8.88);
        secondSaleInstance.updatePaymentDetails(12.0,8.88);
        double changeFirstInstance = firstSaleInstance.getSaleInfo().getChange();
        double changeSecondInstance = secondSaleInstance.getSaleInfo().getChange();
        assertEquals(changeFirstInstance, changeSecondInstance, "Same amount of change in two different sales resulted in two different change amounts.");
    }


    @Test
    void testSaleDate() {
        Date firstSaleDate = firstSaleInstance.getSaleInfo().getSaleDate();
        Date secondSaleDate = secondSaleInstance.getSaleInfo().getSaleDate();
        boolean result = (secondSaleDate.getTime() - firstSaleDate.getTime()) > 20;
        assertTrue(result, "Two different sales started at different times resulted in the same sale start date.");
    }

}