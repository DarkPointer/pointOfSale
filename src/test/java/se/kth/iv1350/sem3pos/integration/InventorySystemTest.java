package se.kth.iv1350.sem3pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InventorySystemTest {

    private InventorySystem inventorySystemInstance;

    @BeforeEach
    void setUp() {
        inventorySystemInstance = new InventorySystem();
    }

    @AfterEach
    void tearDown() {
        inventorySystemInstance = null;
    }

    @Test
    void testEqualItems() {
        ItemInfoDTO firstItem = inventorySystemInstance.getItemInfo("item1");
        ItemInfoDTO secondItem = inventorySystemInstance.getItemInfo("item1");
        boolean result = firstItem.equals(secondItem);
        assertTrue(result, "Fetching two identical items resulted in two items with different information.");

    }

    @Test
    void testUnequalItems() {
        ItemInfoDTO firstItem = inventorySystemInstance.getItemInfo("item1");
        ItemInfoDTO secondItem = inventorySystemInstance.getItemInfo("item4");
        boolean result = firstItem.equals(secondItem);
        assertFalse(result, "Fetching two different items resulted in two items with identical attributes.");
    }
}