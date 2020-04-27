package se.kth.iv1350.sem3pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashRegisterTest {

    private CashRegister firstCashRegisterInstance;
    private CashRegister secondCashRegisterInstance;

    @BeforeEach
    void setUp() {
        firstCashRegisterInstance = new CashRegister();
        secondCashRegisterInstance = new CashRegister();
    }

    @AfterEach
    void tearDown() {
        firstCashRegisterInstance = null;
        secondCashRegisterInstance = null;
    }

    @Test
    void testEqualBalances() {
        firstCashRegisterInstance.increaseBalance(10.2);
        secondCashRegisterInstance.increaseBalance(10.2);
        double firstCashRegisterBalance = firstCashRegisterInstance.getCurrentBalance();
        double secondCashRegisterBalance = secondCashRegisterInstance.getCurrentBalance();
        assertEquals(firstCashRegisterBalance, secondCashRegisterBalance, "Two cash registers with same balance increase "
                + "resulted in different balances.");
    }

    @Test
    void testUnequalBalances() {
        firstCashRegisterInstance.increaseBalance(10.2);
        secondCashRegisterInstance.increaseBalance(18.6);
        double firstCashRegisterBalance = firstCashRegisterInstance.getCurrentBalance();
        double secondCashRegisterBalance = secondCashRegisterInstance.getCurrentBalance();
        assertNotEquals(firstCashRegisterBalance, secondCashRegisterBalance, "Two cash registers with different balance increase "
                + "resulted in same balances.");
    }
}